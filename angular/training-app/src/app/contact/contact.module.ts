import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ContactService} from "./contact.service";
import {HttpClientModule} from "@angular/common/http";
import { ContactMgrComponent } from './contact-mgr/contact-mgr.component';
import { ContactItemComponent } from './contact-item/contact-item.component';
import { ContactDetailsComponent } from './contact-details/contact-details.component';
import { ContactEditorComponent } from './contact-editor/contact-editor.component';
import {ReactiveFormsModule} from "@angular/forms";
import {CalendarModule} from "primeng/calendar";



@NgModule({
  // List available component(s)
  declarations: [
    ContactMgrComponent,
    ContactItemComponent,
    ContactDetailsComponent,
    ContactEditorComponent
  ],
  // Public component(s)
  exports: [
    ContactMgrComponent,
    ContactEditorComponent
  ],
  // Required dependencies
  imports: [
    CommonModule,
    HttpClientModule,
    ReactiveFormsModule,
    CalendarModule
  ],
  // Public service
  providers: [
    ContactService
  ]
})
export class ContactModule { }
