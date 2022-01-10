import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ContactComponent} from './contact/contact.component';
import {ContactDetailComponent} from './contact-detail/contact-detail.component';
import {ContactService} from './contact.service';
import {ContactItemComponent} from './contact-item/contact-item.component';
import {ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    ContactComponent,
    ContactDetailComponent,
    ContactItemComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  exports: [
    ContactComponent
  ],
  providers: [
    ContactService
  ]
})
export class ContactModule {
}
