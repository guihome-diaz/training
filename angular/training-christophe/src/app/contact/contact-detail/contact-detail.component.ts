import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {Contact} from '../contact';
import {ActivatedRoute} from '@angular/router';
import {ContactService} from '../contact.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-contact-detail',
  templateUrl: './contact-detail.component.html',
  styleUrls: ['./contact-detail.component.css']
})
export class ContactDetailComponent implements OnInit, OnChanges {
  @Input() contact: Contact;
  @Output() updated = new EventEmitter<boolean>();

  form: FormGroup;

  constructor(private route: ActivatedRoute,
              private contactService: ContactService,
              private fb: FormBuilder) {
    this.form = this.fb.group({
      id: null,
      firstName: [null, [Validators.required, Validators.pattern('[a-zA-Z]+')]],
      lastName: [null, [Validators.required, Validators.pattern('[a-zA-Z]+')]],
      profession: null,
      socialSecurityNumber: null,
      birthDate: null,
      birthPlace: null,
      address: this.fb.group({
        streetAddress1: null,
        postalCode: null,
        city: null
      })
    });
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      if (params.id) {
        this.contact = null;
        this.reset();
        this.contactService.get(params.id, contact => {
          this.contact = contact;
          this.reset();
        });
      }
    });
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.reset();
  }

  private reset(): void {
    this.form.reset({
      id: this.contact ? this.contact.id : null,
      firstName: this.contact ? this.contact.firstName : null,
      lastName: this.contact ? this.contact.lastName : null,
      profession: this.contact ? this.contact.profession : null,
      socialSecurityNumber: this.contact ? this.contact.socialSecurityNumber : null,
      birthDate: this.contact ? this.contact.birthDate : null,
      birthPlace: this.contact ? this.contact.birthPlace : null,
      address: {
        streetAddress1: this.contact ? this.contact.address.streetAddress1 : null,
        postalCode: this.contact ? this.contact.address.postalCode : null,
        city: this.contact ? this.contact.address.city : null
      }
    });
  }

  submit(): void {
    if (this.form.valid) {
      const contact = this.form.value;
      if (contact.id) {
        this.contactService.update(contact, () => this.updated.emit(true));
      } else {
        this.contactService.create(contact, () => this.updated.emit(false));
      }
    }
  }
}
