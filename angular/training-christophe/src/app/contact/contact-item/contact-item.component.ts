import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Contact} from '../contact';

@Component({
  selector: 'app-contact-item',
  templateUrl: './contact-item.component.html',
  styleUrls: ['./contact-item.component.css']
})
export class ContactItemComponent implements OnInit {
  @Input() contact: Contact;
  @Input() even: boolean;
  @Input() selected: boolean;
  @Output() clickOnMe = new EventEmitter<string>();
  @Output() clickOnDelete = new EventEmitter<string>();

  constructor() {
  }

  ngOnInit(): void {
  }

  onMe(): void {
    this.clickOnMe.emit(this.contact.id);
  }

  delete(): void {
    this.clickOnDelete.emit(this.contact.id);
  }
}
