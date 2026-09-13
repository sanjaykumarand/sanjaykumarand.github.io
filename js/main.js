import { authController } from './auth.js';

/* ---------- Theme Toggle ---------- */
const themeBtn = document.getElementById('themeToggle');
const savedTheme = localStorage.getItem('sk_theme') ||
  (window.matchMedia('(prefers-color-scheme: light)').matches ? 'light' : 'dark');
document.documentElement.setAttribute('data-theme', savedTheme);
updateThemeIcon();

themeBtn?.addEventListener('click', () => {
  const next = document.documentElement.getAttribute('data-theme') === 'light' ? 'dark' : 'light';
  document.documentElement.setAttribute('data-theme', next);
  localStorage.setItem('sk_theme', next);
  updateThemeIcon();
});
function updateThemeIcon() {
  if (!themeBtn) return;
  themeBtn.textContent = document.documentElement.getAttribute('data-theme') === 'light' ? '🌙' : '☀️';
}

/* ---------- Mobile Nav Drawer ---------- */
const menuToggle = document.getElementById('menuToggle');
const navLinks = document.getElementById('navLinks');
menuToggle?.addEventListener('click', () => navLinks.classList.toggle('open'));
navLinks?.querySelectorAll('a').forEach(a => a.addEventListener('click', () => navLinks.classList.remove('open')));

/* ---------- Auth Modal ---------- */
const authModal = document.getElementById('authModal');
const authModalMsg = document.getElementById('authModalMsg');
let pendingAction = null; // function to run after successful sign-in

function openAuthModal(message, onSuccess) {
  pendingAction = onSuccess || null;
  if (authModalMsg && message) authModalMsg.textContent = message;
  authModal?.classList.add('open');
}
function closeAuthModal() { authModal?.classList.remove('open'); }

document.getElementById('authModalClose')?.addEventListener('click', closeAuthModal);
authModal?.addEventListener('click', (e) => { if (e.target === authModal) closeAuthModal(); });

document.getElementById('googleSignInBtn')?.addEventListener('click', async (e) => {
  const btn = e.currentTarget;
  btn.disabled = true; btn.textContent = 'Signing in…';
  const res = await authController.signInWithGoogle();
  btn.disabled = false; btn.innerHTML = '<span>🔵</span> Continue with Google';
  if (res.success) {
    closeAuthModal();
    if (pendingAction) { pendingAction(); pendingAction = null; }
  }
});

/* ---------- Auth State -> Nav UI ---------- */
const signInBtn = document.getElementById('navSignIn');
const userChip = document.getElementById('userChip');
const userChipImg = document.getElementById('userChipImg');
const userChipName = document.getElementById('userChipName');

authController.subscribe((user) => {
  document.body.classList.toggle('is-authed', !!user);
  if (user) {
    signInBtn?.classList.add('hidden');
    userChip?.classList.remove('hidden');
    if (userChipImg) userChipImg.src = user.photoURL;
    if (userChipName) userChipName.textContent = user.displayName;
  } else {
    signInBtn?.classList.remove('hidden');
    userChip?.classList.add('hidden');
  }
  applyGating();
});

signInBtn?.addEventListener('click', () => openAuthModal('Sign in with Google to unlock full access to the portfolio.'));
userChip?.addEventListener('click', async () => {
  if (confirm('Sign out of your account?')) await authController.logout();
});

/* ---------- Content Gating ----------
   Elements with [data-gate="true"] get blurred + overlaid until signed in.
   Buttons/links with [data-gate-action] require sign-in before navigating;
   pass the real destination in [data-gate-href] or [data-gate-onclick].
*/
function applyGating() {
  const signedIn = !!authController.currentUser;

  document.querySelectorAll('[data-gate="true"]').forEach(el => {
    if (el.dataset.gateInit) { /* already wrapped */ }
    else wrapGate(el);
    const overlay = el.parentElement.querySelector('.gate-overlay');
    if (signedIn) {
      el.classList.remove('gate-blur');
      overlay?.classList.add('hidden');
    } else {
      el.classList.add('gate-blur');
      overlay?.classList.remove('hidden');
    }
  });

  document.querySelectorAll('[data-gate-action]').forEach(el => {
    if (!el.dataset.gateBound) {
      el.dataset.gateBound = 'true';
      el.dataset.gateOrigLabel = el.textContent.trim();
      const href = el.getAttribute('data-gate-href');
      const label = el.dataset.gateLabel || 'Sign in with Google to view this content.';
      el.addEventListener('click', (e) => {
        if (!authController.currentUser) {
          e.preventDefault();
          openAuthModal(label, () => { if (href) window.location.href = href; });
        }
      });
    }
    // visual lock/unlock state
    const baseLabel = el.dataset.gateOrigLabel;
    if (signedIn) {
      el.classList.remove('btn-locked');
      el.textContent = baseLabel;
    } else {
      el.classList.add('btn-locked');
      el.textContent = '🔒 ' + baseLabel;
    }
  });
}

function wrapGate(el) {
  el.dataset.gateInit = 'true';
  const wrap = document.createElement('div');
  wrap.className = 'gate-wrap';
  el.parentElement.insertBefore(wrap, el);
  wrap.appendChild(el);
  const overlay = document.createElement('div');
  overlay.className = 'gate-overlay glass-panel hidden';
  overlay.innerHTML = `
    <div class="lock-icon">🔒</div>
    <p>${el.dataset.gateMsg || 'Sign in with Google to view this content.'}</p>
    <button class="btn btn-primary btn-sm gate-signin">Sign in with Google</button>`;
  wrap.appendChild(overlay);
  overlay.querySelector('.gate-signin').addEventListener('click', () => openAuthModal());
}

applyGating();

/* ---------- Fade-in on scroll ---------- */
const io = new IntersectionObserver((entries) => {
  entries.forEach(en => { if (en.isIntersecting) { en.target.style.opacity = 1; en.target.style.transform = 'translateY(0)'; } });
}, { threshold: 0.12 });
document.querySelectorAll('.glass-panel, .section-head').forEach(el => {
  el.style.opacity = 0; el.style.transform = 'translateY(18px)';
  el.style.transition = 'opacity .6s ease, transform .6s ease';
  io.observe(el);
});
