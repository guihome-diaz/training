import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';
import {SharedData} from "../../shared-data";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login: string;
  password: string;
  @Input()  defaultLogin: string;

  constructor(public sharedData: SharedData) { }

  ngOnInit(): void {
    // This method is called every time the component is render
    //  not just when the component is created!
    this.login = this.defaultLogin;
  }

  validateCredentials() {
    // v1: check manuel
    // v2: send event to parent (login + password)
    // v3: send event to parent, only login, if credentials are ok
    // v4: adjust common shared data
    if (this.login === this.password) {
      this.sharedData.sessionId = 'fake session ID';
      this.sharedData.errorMessage = undefined;
    } else {
      this.sharedData.errorMessage = 'KO - not authorized (bad credentials)';
    }
  }
}
