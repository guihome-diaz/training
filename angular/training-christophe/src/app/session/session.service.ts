import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {SharedData} from '../app-base/shared-data';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  constructor(private httpClient: HttpClient, private sharedData: SharedData) {
  }

  login(user: string, pwd: string, callback: Function): void {
    this.httpClient.post<any>(
      'http://localhost:5000/api/session',
      {login: user, password: pwd}
    ).subscribe(
      data => {
        this.sharedData.errorMessage = null;
        this.sharedData.sessionId = data.sessionId;
        callback();
      },
      err => this.sharedData.errorMessage = 'Error: ' + err.message
    );
  }

  logout(callback: Function): void {
    this.httpClient.delete(
      'http://localhost:5000/api/session',
      {params: new HttpParams().set('id', this.sharedData.sessionId)}
    ).subscribe(
      () => {
        this.sharedData.errorMessage = null;
      },
      err => {
        this.sharedData.errorMessage = 'Error: ' + err.message;
      },
      () => {
        this.sharedData.sessionId = null;
        if (callback) {
          callback();
        }
      }
    );
  }
}
