
import { Component, OnInit } from '@angular/core';
import { KeycloakServiceService } from './services/keycloak-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  title = 'clinic-app-front';
  isAdmin: boolean = false;
  isUser: boolean = false;

  constructor(public keycloakService: KeycloakServiceService) {}

  ngOnInit(): void {
    this.keycloakService.initialized.subscribe((initialized) => {
      if (initialized) {
        console.log('isAdmin', this.isAdmin);
        console.log('isUser', this.isUser);
      }
    });
  }
}
