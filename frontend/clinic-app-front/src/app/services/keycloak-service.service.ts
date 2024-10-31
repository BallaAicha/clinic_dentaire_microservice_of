import { UserProfile } from './user-profile';
import { BehaviorSubject } from 'rxjs';
import { Injectable } from '@angular/core';
import Keycloak from 'keycloak-js';

@Injectable({
  providedIn: 'root'
})
export class KeycloakServiceService {
  private _keycloak: Keycloak | undefined;
  private _profile: UserProfile | undefined;
  public initialized = new BehaviorSubject<boolean>(false);

  get keycloak() {
    if (!this._keycloak) {
      this._keycloak = new Keycloak({
        url: 'http://localhost:9099',
        realm: 'clinic-microservices',
        clientId: 'clinic-microservices',
      });
    }
    return this._keycloak;
  }

  get profile(): UserProfile | undefined {
    return this._profile;
  }

  constructor() {}

  async init() {
    console.log('Authentification en cours...');
    try {
      const authenticated = await this.keycloak.init({
        onLoad: 'login-required'
      });
      if (authenticated) {
        console.log('Authentification réussie');
        console.log(this.keycloak.tokenParsed);
        this._profile = (await this.keycloak.loadUserProfile()) as UserProfile;
        this._profile.token = this.keycloak.token || '';
      } else {
        console.log('Authentification non réussie');
      }
      this.initialized.next(authenticated);
    } catch (error) {
      console.error('Erreur lors de l\'authentification:', error);
      this.initialized.next(false);
    }
  }

  async login() {
    try {
      await this.keycloak.login();
    } catch (error) {
      console.error('Erreur lors de la connexion:', error);
    }
  }

  async logout() {
    try {
      await this.keycloak.logout({
        redirectUri: 'http://localhost:4200'
      });
    } catch (error) {
      console.error('Erreur lors de la déconnexion:', error);
    }
  }

  isLoggedIn() {
    return this.keycloak.authenticated;
  }

  loadUserProfile() {
    return this.keycloak.loadUserProfile();
  }

  hasRole(role: string): boolean {
    if (!this.keycloak.authenticated) return false;
    // @ts-ignore
    const roles = this.keycloak.tokenParsed.realm_access.roles;
    return roles.indexOf(role) > -1;
  }
}
