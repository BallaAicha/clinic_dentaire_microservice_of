import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { PatientsService } from '../../services/patients/patients.service';
import {Patient} from "../../model/patient.model";


@Component({
  selector: 'app-patients',
  templateUrl: './patients.component.html',
  styleUrls: ['./patients.component.css']
})
export class PatientsComponent implements OnInit {
  patients: Patient[] = [];

  constructor(private modalService: NgbModal, private patientsService: PatientsService) {}

  ngOnInit(): void {
    this.patientsService.getPatients().subscribe((data: Patient[]) => {
      this.patients = data;
    });
  }

  getModal(content: any) {
    this.modalService.open(content, { size: 'xl' });
    console.log('Hello world');
  }
}
