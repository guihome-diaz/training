import {Component, Input, OnInit, Output} from '@angular/core';
import {Contact} from "../contact";
import {ContactService} from "../contact.service";

@Component({
  selector: 'app-contact-mgr',
  templateUrl: './contact-mgr.component.html',
  styleUrls: ['./contact-mgr.component.css']
})
export class ContactMgrComponent implements OnInit {

  contactList: Contact[];
  selectedContact: Contact;

  constructor(public contactService: ContactService) {
  }

  ngOnInit(): void {
    this.contactService.fetchAll((data) => { this.contactList = data});
  }

  // Triggered by contact-item choice (event)
  onItemClicked(chosenContact: Contact) {
    this.selectedContact = chosenContact;
  }

  onItemDeleted(contactId: string) {
    // Disable selected contact, if applicable
    if (this.selectedContact && this.selectedContact.id === contactId) {
      this.selectedContact = undefined;
    }
    // remove from list
    this.contactList.splice(this.contactList.findIndex(item => item.id === contactId),1);
  }

  onItemUpdated(contactChanged: Contact) {
    // Array list
    let contactIndex = this.contactList.findIndex(item => item.id === contactChanged.id);
    if (contactIndex >= 0) {
      // update value
      this.contactList[contactIndex] = contactChanged;
    } else {
      // add value
      this.contactList.push(contactChanged);
    }

    // Selected item
    if (this.selectedContact && this.selectedContact.id === contactChanged.id) {
      this.selectedContact = contactChanged;
    }

  }

}
