import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ContactService} from "./contact.service";
import {HttpClientModule} from "@angular/common/http";
import { ContactMgrComponent } from './contact-mgr/contact-mgr.component';
import { ContactItemComponent } from './contact-item/contact-item.component';
import { ContactDetailsComponent } from './contact-details/contact-details.component';



@NgModule({
  // List available component(s)
  declarations: [
    ContactMgrComponent,
    ContactItemComponent,
    ContactDetailsComponent
  ],
  // Public component(s)
  exports: [
    ContactMgrComponent
  ],
  // Required dependencies
  imports: [
    CommonModule,
    HttpClientModule
  ],
  // Public service
  providers: [
    ContactService
  ]
})
export class ContactModule { }
