import { Injectable } from '@angular/core';


import {Dentiste, Salle} from "../../model/dentiste.model.js";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../../environments/environment.js";

@Injectable({
  providedIn: 'root'
})
export class DentistesService {
  private apiUrl = `${environment.backendHost}/users/dentistes`;
  private sallesUrl = `${environment.backendHost2}/equipments/salles`;

  constructor(private http: HttpClient) { }

  getDentistes(): Observable<Dentiste[]> {
    return this.http.get<Dentiste[]>(this.apiUrl);
  }

  getSalles(): Observable<Salle[]> {
    return this.http.get<Salle[]>(this.sallesUrl);
  }

  addDentiste(dentiste: Dentiste): Observable<Dentiste> {
    return this.http.post<Dentiste>(this.apiUrl, dentiste);
  }


}
