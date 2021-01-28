import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ContactService} from "../contact.service";
import {SharedData} from "../../shared-data";
import {Contact} from "../contact";

@Component({
  selector: 'app-contact-editor',
  templateUrl: './contact-editor.component.html',
  styleUrls: ['./contact-editor.component.css']
})
export class ContactEditorComponent implements OnInit {


  contact: Contact;

  constructor(private contactService: ContactService, private activatedRoute: ActivatedRoute, public sharedData: SharedData) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      // get param value
      const contactId = params['id'];
      // process value
      if (contactId) {
        this.contactService.fetchById(contactId).subscribe(
          dataSuccess => {
            this.sharedData.clearError();
            this.contact = dataSuccess;
          },
          err => {
            this.sharedData.setError(err);
          }
        )
      } else {
        this.sharedData.setError('No Contact ID provided');
      }
    });
  }

}
