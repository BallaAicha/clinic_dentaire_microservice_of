import {Component, OnInit} from '@angular/core';
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-rendezvous',
  templateUrl: './rendezvous.component.html',
  styleUrl: './rendezvous.component.css'
})
export class RendezvousComponent  implements OnInit{
  constructor(private modalService: NgbModal) {
  }

  ngOnInit(): void {
  }


  getModal(content: any) {
    this.modalService.open(content, {size: 'xl'})
    console.log("Hello world")
  }

}
