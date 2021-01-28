import {Component, EventEmitter, Input, OnChanges, OnInit, Output} from '@angular/core';
import {Contact} from "../contact";
import {FormBuilder, FormControl, FormGroup, ValidationErrors, Validators} from "@angular/forms";
import {ContactService} from "../contact.service";
import {SharedData} from "../../shared-data";

@Component({
  selector: 'app-contact-details',
  templateUrl: './contact-details.component.html',
  styleUrls: ['./contact-details.component.css']
})
export class ContactDetailsComponent implements OnInit, OnChanges {

  // input data
  @Input() contact: Contact;
  // Output data
  @Output() itemDeleted = new EventEmitter<string>();
  @Output() itemChanged = new EventEmitter<Contact>();

  // UI values
  public contactForm: FormGroup;

  constructor(public formBuilder: FormBuilder, private contactService: ContactService, private sharedData: SharedData) {
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
    if (!this.contact) {
      this.contact = new Contact();
    }
  }

  ngOnChanges(): void {
    if (!this.contact?.id) {
      this.contact = new Contact();
    }
    // Triggered on content changes: populate values
    this.contactForm.reset({
      id: this.contact.id,
      firstName: this.contact.firstName,
      lastName: this.contact.lastName,
      profession:this.contact.profession,
      socialSecurityNumber: this.contact.socialSecurityNumber,
      birthDate: new Date(this.contact.birthDate),
      birthPlace: this.contact.birthPlace,
      address: {
        streetAddress1: this.contact.address.streetAddress1,
        postalCode: this.contact.address ? this.contact.address.postalCode : null,
        city: this.contact.address ? this.contact.address.city :null
      }
    });
  }

  onDelete() {
    console.log('Valid form?' + this.contactForm.valid);
    if (!this.contactForm.valid) {
      // List errors
      this.getFormValidationErrors();
      return;
    }
    // you can check using form value or object attribute: it is the same because the field is read only
    if (!this.contactForm.get('id')) {
      this.sharedData.setError('Cannot delete non persisted object (ID null)');
      return;
    }

    // Delete
    this.contactService.deleteContact(this.contact.id, () => {
      this.sharedData.clearError();
      this.itemDeleted.emit(this.contact.id);
    });
  }

  onSubmit() {
    this.sharedData.clearError();

    console.log('Valid form?' + this.contactForm.valid);
    if (!this.contactForm.valid) {
      // List errors
      this.getFormValidationErrors();
      return;
    }

    const submitContact = this.contactForm.value;

    if (submitContact.id) {
      // update
      this.contactService.updateContact(submitContact, (contact) => {
        this.sharedData.clearError();
        this.itemChanged.emit(contact);
      });
    } else {
      // create
      this.contactService.createContact(submitContact, (contact) => {
        this.sharedData.clearError();
        this.itemChanged.emit(contact);
      });
    }
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
