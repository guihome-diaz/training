import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login: string | undefined;
  password: string | undefined;
  result: string | undefined;

  constructor() { }

  ngOnInit(): void {
    this.login = "";
    this.password = "";
    this.result = "";
  }

  validatePassword() {
    if (this.login === this.password) {
      this.result = 'OK';
    } else {
      this.result = 'KO - not authorized';
    }
  }
}
