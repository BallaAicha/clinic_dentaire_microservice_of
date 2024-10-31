import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';
import {Patient} from "../../model/patient.model";


@Injectable({
  providedIn: 'root'
})
export class PatientsService {
  private apiUrl = `${environment.backendHost1}/patients/patient`;

  constructor(private http: HttpClient) { }

  getPatients(): Observable<Patient[]> {
    return this.http.get<Patient[]>(this.apiUrl);
  }
}
