import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DentistesComponent } from './components/dentistes/dentistes.component';
import { HeaderComponent } from './components/header/header.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { PatientsComponent } from './components/patients/patients.component';
import { RendezvousComponent } from './components/rendezvous/rendezvous.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';
import { HttpTokenInterceptor } from './interceptor/http-token.interceptor';
import { RouterModule, Routes } from '@angular/router';
import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HTTP_INTERCEPTORS, HttpClient, HttpClientModule} from '@angular/common/http';
import { KeycloakServiceService } from './services/keycloak-service.service';
import {FormsModule} from "@angular/forms";

const appRoutes: Routes = [
  { path: '', component: DentistesComponent },
  { path: 'patients', component: PatientsComponent },
  { path: 'rendezvous', component: RendezvousComponent },
  { path: 'dentistes', component: DentistesComponent },
  { path: 'navbar', component: NavbarComponent },
  { path: 'header', component: HeaderComponent },
];

function initializeKeycloak(keycloak: KeycloakServiceService) {
  return () => keycloak.init();
}

@NgModule({
  declarations: [
    AppComponent,
    DentistesComponent,
    HeaderComponent,
    NavbarComponent,
    PatientsComponent,
    RendezvousComponent,
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        RouterModule.forRoot(appRoutes, {enableTracing: false}),
        NgbModule,
        KeycloakAngularModule,
        HttpClientModule,
        FormsModule,
    ],
  providers: [
    HttpClient,
    KeycloakService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpTokenInterceptor,
      multi: true
    },
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      multi: true,
      deps: [KeycloakServiceService]
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
