import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Contact} from "./contact";
import {SharedData} from "../shared-data";
import {Observable} from "rxjs";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  backendUrl: string;

  constructor(public httpClient: HttpClient, public sharedData: SharedData) {
    this.backendUrl = 'http://localhost:5000/api/contact';
  }

  // POST http://localhost:5000/api/contact  json payload
  createContact(newContact: Contact, callback: Function) {
    this.httpClient.post(
      this.backendUrl,
      newContact
    ).subscribe(
      data => {
        this.sharedData.clearError();
        newContact.id = data['id'];
        callback(newContact);
      },
      err => {
        this.sharedData.setError(err);
      }
    )
  }

  // GET http://localhost:5000/api/contact
  fetchAll(callback: Function): void {
      this.httpClient.get<Contact[]>(this.backendUrl)
        .subscribe(
          data => {
            this.sharedData.clearError();
            // populate content async
            if (callback) {
              callback(data);
            }
          },
          err => {
            this.sharedData.setError(err);
          }
        );
  }


  // GET http://localhost:5000/api/contact?id=123456
  fetchById(searchId: string) : Observable<Contact> {
    return this.httpClient.get<Contact>(
      this.backendUrl,
      { params: new HttpParams().set('id', searchId) }
    );
  }

  // PUT http://localhost:5000/api/contact
  updateContact(contactChanged: Contact, callback: Function) {
    this.httpClient.put(
      this.backendUrl,
      contactChanged
    ).subscribe(
      data => {
        this.sharedData.clearError();
        callback(contactChanged);
      },
      err => {
        this.sharedData.setError(err);
      }
    )
  }

  // DELETE http://localhost:5000/api/contact
  deleteContact(searchId: string, callback: Function) {
    this.httpClient.delete(
      this.backendUrl,
      { params: new HttpParams().set('id', searchId) }
    ).subscribe(
      data => {
        this.sharedData.clearError();
        // redirect to user list
        callback();
      },
      err => {
        this.sharedData.setError(err);
      }
    )
  }
}
