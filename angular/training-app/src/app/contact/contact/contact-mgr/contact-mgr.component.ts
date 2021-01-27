import {Component, Input, OnInit, Output} from '@angular/core';
import {Contact} from "../../contact";
import {ContactService} from "../../contact.service";

@Component({
  selector: 'app-contact-mgr',
  templateUrl: './contact-mgr.component.html',
  styleUrls: ['./contact-mgr.component.css']
})
export class ContactMgrComponent implements OnInit {

  contactList: Contact[];

  // Incoming data/event
  selectedContact: Contact;

  // Outgoing events


  constructor(public contactService: ContactService) { }

  ngOnInit(): void {
    this.contactService.fetchAll((data) => { this.contactList = data});
  }

  // Triggered by contact-item choice (event)
  onItemClicked(chosenContact: Contact) {
    this.selectedContact = chosenContact;
  }
}
