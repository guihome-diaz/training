import {Component, Input, OnChanges, OnInit, Output, EventEmitter} from '@angular/core';
import {Contact} from "../../contact";

@Component({
  selector: 'app-contact-item',
  templateUrl: './contact-item.component.html',
  styleUrls: ['./contact-item.component.css']
})
export class ContactItemComponent implements OnInit, OnChanges {

  // Callbacks
  @Input() contact: Contact;
  @Input() isEvenRow: boolean;
  @Input() isSelected: boolean;

  // Events
  @Output() itemClicked = new EventEmitter<Contact>();

  // Attributes
  cssClass: string;

  constructor() { }

  ngOnInit(): void {
  }

  ngOnChanges(): void {
    if (this.isSelected) {
      this.cssClass = 'selectedRow';
    } else {
      if (this.isEvenRow) {
        this.cssClass = 'evenRow';
      } else {
        this.cssClass = 'oddRow';
      }
    }
  }

  onContactClick() {
    this.itemClicked.emit(this.contact);
  }
}
