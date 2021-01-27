import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {SharedData} from "../shared-data";

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  constructor(public httpClient: HttpClient, public sharedData: SharedData) { }

  // Login URL: POST   http://localhost:5000/api/session    (with JSON body)
  login(userId: string, password: string, callback: Function) {
    // See the Oxiane mocks ; SessionServices.js
    // JSON format expected, with 2 attributes: login, password

    const serviceBackendUrl = 'http://localhost:5000/api/session';

    this.httpClient.post(
      serviceBackendUrl,
      {login: userId, password: password}
      ).subscribe(
        data => {
          this.sharedData.sessionId = data['sessionId'];
          this.sharedData.clearError();
          // notify caller
          callback();
        },
        err => {
          this.sharedData.setError(err);
        }
      )
  }

  // Logout URL: DELETE   http://localhost:5000/api/session?id=abxcd-z18a-da8e-125af
  logout(callback: Function) {
    // See the Oxiane mocks ; SessionServices.js
    // JSON format expected, with 2 attributes: login, password

    const serviceBackendUrl = 'http://localhost:5000/api/session';

    this.httpClient.delete(
      serviceBackendUrl,
      { params: new HttpParams().set('id', this.sharedData.sessionId) }
    ).subscribe(
      data => {
        this.sharedData.sessionId = undefined;
        this.sharedData.errorMessage = undefined;
        callback();
      },
      err => {
        this.sharedData.errorMessage = err.errorMessage;
      }
    )
  }

}
