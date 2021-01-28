import {Component, OnInit} from '@angular/core';
import {ContactService} from '../contact.service';
import {Contact} from '../contact';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  contacts: Contact[];
  selectedContact: Contact;

  constructor(private contactService: ContactService) {
  }

  ngOnInit(): void {
    this.loadList();
  }

  loadList(): void {
    this.contactService.list(contacts => this.contacts = contacts);
  }

  delete(id: string): void {
    if (this.selectedContact && id === this.selectedContact.id) {
      this.selectedContact = null;
    }

    this.contactService.delete(id, () => this.loadList());
  }

  select(id: string): void {
    if (this.selectedContact && id === this.selectedContact.id) {
      this.selectedContact = null;
    } else {
      this.contactService.get(id, contact => this.selectedContact = contact);
    }
  }

  new(): void {
    this.selectedContact = Contact.new();
  }

  update(keepSelected: boolean): void {
    if (!keepSelected) {
      this.selectedContact = null;
    }
    this.loadList();
  }
}
