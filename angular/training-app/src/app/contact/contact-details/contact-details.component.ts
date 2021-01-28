import {Component, Input, OnChanges, OnInit} from '@angular/core';
import {Contact} from "../contact";
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {Address} from "../address";

@Component({
  selector: 'app-contact-details',
  templateUrl: './contact-details.component.html',
  styleUrls: ['./contact-details.component.css']
})
export class ContactDetailsComponent implements OnInit, OnChanges {

  // input data
  @Input() contact: Contact;

  // UI values
  public contactForm: FormGroup;

  constructor(public formBuilder: FormBuilder) {
    // Create form fields to map on the UI (HTML) later on
    this.contactForm = this.formBuilder.group({
      id: new FormControl(),
      firstName: new FormControl(),
      lastName: new FormControl(),
      profession: new FormControl(),
      socialSecurityNumber: new FormControl(),
      birthDate: new FormControl(),
      birthPlace: new FormControl(),
      address: new FormGroup({
        streetAddress1: new FormControl(),
        postalCode: new FormControl(),
        city: new FormControl()
      })
    });
  }

  ngOnInit(): void {
  }

  ngOnChanges(): void {
    // Triggered on content changes: populate values
    this.contactForm.reset({
      id: this.contact.id,
      firstName: this.contact.firstName,
      lastName: this.contact.lastName,
      profession:this.contact.profession,
      socialSecurityNumber: this.contact.socialSecurityNumber,
      birthDate: this.contact.birthDate,
      birthPlace: this.contact.birthPlace,
      address: {
        streetAddress1: this.contact.address?.streetAddress1,
        postalCode: this.contact.address?.postalCode,
        city: this.contact.address?.city
      }
    });
  }

  onSubmit() {
    // TODO handle form submit
  }

}
