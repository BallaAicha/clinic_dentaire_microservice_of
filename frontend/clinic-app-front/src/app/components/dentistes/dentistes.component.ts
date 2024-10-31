import {Component, OnInit} from '@angular/core';
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {DentistesService} from "../../services/dentistes/dentistes.service.js";
import {Dentiste, Salle} from "../../model/dentiste.model.js";

@Component({
  selector: 'app-dentistes',
  templateUrl: './dentistes.component.html',
  styleUrl: './dentistes.component.css'
})
export class DentistesComponent implements OnInit {
  dentistes: Dentiste[] = [];
  salles: Salle[] = [];
  newDentiste: Dentiste = {
    dentisteId: 0,
    prenom: '',
    specialite: '',
    telephone: '',
    user: {
      email: '',
      password: ''
    },
    salle: {
      salleId: 0,
      nom: ''
    }
  };

  constructor(private modalService: NgbModal, private dentistesService: DentistesService) {}

  ngOnInit(): void {
    this.dentistesService.getDentistes().subscribe(
      (data: Dentiste[]) => {
        this.dentistes = data;
        console.log(data);
      },
      (error) => {
        console.error('Error fetching dentistes', error);
      }
    );

  }

  getModal(content: any){
    this.dentistesService.getSalles().subscribe(
      (data: Salle[]) => {
        this.salles = data;
        console.log(data);
      },
      (error) => {
        console.error('Error fetching salles', error);
      }
    );
    this.modalService.open(content, { size: 'xl' });
    console.log("Hello world");
  }
  onSubmit() {
    this.dentistesService.addDentiste(this.newDentiste).subscribe(
      (data: Dentiste) => {
        this.dentistes.push(data);
        console.log('Dentiste created successfully', data);
        this.modalService.dismissAll();
      },

      (error) => {
        console.error('Error creating dentiste', error);
      }
    );
  }




}
