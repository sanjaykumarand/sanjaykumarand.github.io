// Firebase Configuration — Firebase v10 Modular SDK (CDN)
// NOTE: the SDK is loaded dynamically and wrapped in try/catch below so that a
// blocked/offline network (ad-blockers, school/office wifi, file:// testing)
// falls back to Demo Mode instead of breaking the whole page.

/**
 * -------------------------------------------------------------
 * SETUP INSTRUCTIONS:
 * 1. https://console.firebase.google.com/ -> Create project -> Add Web App.
 * 2. Authentication > Sign-in method > enable "Google".
 * 3. Authentication > Settings > Authorized domains: add your GitHub Pages
 *    domain (e.g. sanjaykumarand.github.io) and localhost.
 * 4. Paste your config values below. Until you do, the site runs in
 *    Demo Mode so you can preview the sign-in gating locally.
 * -------------------------------------------------------------
 */
const firebaseConfig = {
  apiKey: "AIzaSyBeEpHQs54nVfql8uS-KrfBsL_aUlk4fSg",
  authDomain: "sanjaykumaran-portfolio.firebaseapp.com",
  projectId: "sanjaykumaran-portfolio",
  storageBucket: "sanjaykumaran-portfolio.firebasestorage.app",
  messagingSenderId: "1013888837773",
  appId: "1:1013888837773:web:b0491ab2fcee1e7b14dac4",
  measurementId: "G-VQGCRXE46T"
};

export const hasRealKeys = Boolean(
  firebaseConfig.apiKey && !firebaseConfig.apiKey.includes("YOUR_")
);

let app = null, auth = null, googleProvider = null;
let signInWithPopup = null, signOut = null, onAuthStateChanged = null;
export let isConfigured = false;

// Dynamically import the Firebase SDK so a network failure (blocked domain,
// offline testing, file:// protocol) can never take down the rest of the site.
export const firebaseReady = (async () => {
  if (!hasRealKeys) {
    console.log('%c[Firebase]%c Demo Mode — add real keys in js/firebase-config.js to go live.', 'color:#f59e0b;font-weight:bold', 'color:inherit');
    return;
  }
  try {
    const [{ initializeApp }, authMod] = await Promise.all([
      import('https://www.gstatic.com/firebasejs/10.12.0/firebase-app.js'),
      import('https://www.gstatic.com/firebasejs/10.12.0/firebase-auth.js')
    ]);
    const { getAuth, GoogleAuthProvider, signInWithPopup: sp, signOut: so, onAuthStateChanged: oasc } = authMod;
    app = initializeApp(firebaseConfig);
    auth = getAuth(app);
    googleProvider = new GoogleAuthProvider();
    googleProvider.setCustomParameters({ prompt: 'select_account' });
    signInWithPopup = sp; signOut = so; onAuthStateChanged = oasc;
    isConfigured = true;
    console.log('%c[Firebase]%c Connected to live Google Auth.', 'color:#f5c542;font-weight:bold', 'color:inherit');
  } catch (err) {
    isConfigured = false;
    console.warn('[Firebase] Could not load SDK (network/CORS?) — falling back to Demo Mode:', err.message);
  }
})();

export { auth, googleProvider, signInWithPopup, signOut, onAuthStateChanged };
