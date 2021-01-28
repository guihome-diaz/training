import {Component, Input, OnChanges, OnInit} from '@angular/core';
import {Contact} from "../contact";
import {FormBuilder, FormControl, FormGroup, ValidationErrors, Validators} from "@angular/forms";
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
      firstName: new FormControl(null, [Validators.required, Validators.min(2)]),
      lastName: new FormControl(null, [Validators.required, Validators.min(2)]),
      profession: new FormControl(),
      socialSecurityNumber: new FormControl(null, [Validators.required, Validators.minLength(13), Validators.maxLength(13), Validators.pattern("[0-9]*")]),
      birthDate: new FormControl(Validators.required),
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
        streetAddress1: this.contact.address.streetAddress1,
        postalCode: this.contact.address ? this.contact.address.postalCode : null,
        city: this.contact.address ? this.contact.address.city :null
      }
    });
  }

  onSubmit() {
    // List errors
    console.log('Valid form?' + this.contactForm.valid);
    this.getFormValidationErrors()
  }

  /**
   * To list all errors
   */
  getFormValidationErrors() {
    Object.keys(this.contactForm.controls).forEach(key => {
      const controlErrors: ValidationErrors = this.contactForm.get(key).errors;
      if (controlErrors != null) {
        Object.keys(controlErrors).forEach(keyError => {
          console.log('Form validation error # Field name: ' + key + ', error type: ' + keyError + ', error: ', controlErrors[keyError]);
        });
      }
    });
  }
}
