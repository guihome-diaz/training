import {Component, Input, OnInit} from '@angular/core';
import {Contact} from "../contact";

@Component({
  selector: 'app-contact-details',
  templateUrl: './contact-details.component.html',
  styleUrls: ['./contact-details.component.css']
})
export class ContactDetailsComponent implements OnInit {

  // input data
  @Input() contact: Contact;

  constructor() {
  }

  ngOnInit(): void {
  }


}
