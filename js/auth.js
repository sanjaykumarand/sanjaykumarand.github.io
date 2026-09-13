// Authentication Controller — Google Sign-In with Demo Fallback
import { firebaseReady } from './firebase-config.js';
import * as fb from './firebase-config.js';

class AuthController {
  constructor() {
    this.currentUser = null;
    this.listeners = [];
    // Show a demo-mode session immediately (don't block UI on network),
    // then re-check once Firebase has had a chance to load (or fail).
    this.init();
    firebaseReady.then(() => this.init());
  }

  init() {
    if (fb.isConfigured && fb.auth) {
      fb.onAuthStateChanged(fb.auth, (user) => {
        this.currentUser = user ? {
          uid: user.uid,
          displayName: user.displayName || user.email.split('@')[0],
          email: user.email,
          photoURL: user.photoURL || `https://api.dicebear.com/7.x/avataaars/svg?seed=${user.email}`
        } : null;
        this.notify();
      });
    } else {
      const saved = localStorage.getItem('sk_portfolio_auth_user');
      if (saved) { try { this.currentUser = JSON.parse(saved); } catch (e) { this.currentUser = null; } }
      this.notify();
    }
  }

  subscribe(cb) { this.listeners.push(cb); cb(this.currentUser); }
  notify() { this.listeners.forEach(cb => cb(this.currentUser)); }

  async signInWithGoogle() {
    await firebaseReady; // wait for SDK load attempt to finish (fast when demo/offline)
    if (fb.isConfigured && fb.auth) {
      try {
        const result = await fb.signInWithPopup(fb.auth, fb.googleProvider);
        return { success: true, user: result.user };
      } catch (error) {
        console.error('Google Auth Error:', error);
        return { success: false, error: error.message };
      }
    } else {
      const demoUser = {
        uid: 'demo-' + Date.now(),
        displayName: 'Demo Visitor',
        email: 'demo.visitor@example.com',
        photoURL: 'https://api.dicebear.com/7.x/avataaars/svg?seed=demo-visitor',
        isDemo: true
      };
      this.currentUser = demoUser;
      localStorage.setItem('sk_portfolio_auth_user', JSON.stringify(demoUser));
      this.notify();
      return { success: true, user: demoUser, isDemo: true };
    }
  }

  async logout() {
    await firebaseReady;
    if (fb.isConfigured && fb.auth) {
      try { await fb.signOut(fb.auth); } catch (err) { console.error('Signout error:', err); }
    } else {
      localStorage.removeItem('sk_portfolio_auth_user');
      this.currentUser = null;
      this.notify();
    }
  }
}

export const authController = new AuthController();
