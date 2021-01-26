import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login: string;
  password: string;
  loginError: string;
  @Input()  defaultLogin: string;
  @Output() credentialsEvent = new EventEmitter<any>();

  constructor() { }

  ngOnInit(): void {
    // This method is called every time the component is render
    //  not just when the component is created!
    this.login = this.defaultLogin;
  }

  validateCredentials() {
    // v1: check manuel
    // v2: send event to parent (login + password)
    // v3: send event to parent, only login, if credentials are ok
    if (this.login === this.password) {
      this.loginError = undefined;
      this.credentialsEvent.emit({ login: this.login });
    } else {
      this.loginError = 'KO - not authorized';
    }
  }
}
