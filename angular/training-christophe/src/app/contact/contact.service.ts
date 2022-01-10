import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Contact} from './contact';
import {SharedData} from '../app-base/shared-data';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  constructor(private httpClient: HttpClient, private sharedData: SharedData) {
  }

  list(callback: Function): any {
    return this.httpClient.get(
      'http://localhost:5000/api/contact'
    ).subscribe(
      data => {
        this.sharedData.errorMessage = null;
        if (callback) {
          callback(data);
        }
      },
      err => this.sharedData.errorMessage = 'Error: ' + err.message
    );
  }

  get(id: string, callback: Function): any {
    this.httpClient.get(
      'http://localhost:5000/api/contact',
      {params: new HttpParams().set('id', id)}
    ).subscribe(
      data => {
        this.sharedData.errorMessage = null;
        if (callback) {
          callback(data);
        }
      },
      err => this.sharedData.errorMessage = 'Error: ' + err.message
    );
  }

  create(contact: Contact, callback: Function): any {
    this.httpClient.post(
      'http://localhost:5000/api/contact',
      contact
    ).subscribe(
      () => {
        this.sharedData.errorMessage = null;
        if (callback) {
          callback();
        }
      },
      err => this.sharedData.errorMessage = 'Error: ' + err.message
    );
  }

  update(contact: Contact, callback: Function): any {
    this.httpClient.put(
      'http://localhost:5000/api/contact',
      contact
    ).subscribe(
      () => {
        this.sharedData.errorMessage = null;
        if (callback) {
          callback();
        }
      },
      err => this.sharedData.errorMessage = 'Error: ' + err.message
    );
  }

  delete(id: string, callback: Function): any {
    this.httpClient.delete(
      'http://localhost:5000/api/contact',
      {params: new HttpParams().set('id', id)}
    ).subscribe(
      () => {
        this.sharedData.errorMessage = null;
        if (callback) {
          callback();
        }
      },
      err => this.sharedData.errorMessage = 'Error: ' + err.message
    );
  }
}
