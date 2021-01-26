import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login: string;
  @Input()  defaultLogin: string;
  @Output() credentials = new EventEmitter<any>();
  password: string;

  constructor() { }

  ngOnInit(): void {
    // This method is called every time the component is render
    //  not just when the component is created!
    this.login = this.defaultLogin;
  }

  validatePassword() {
    // v1: check manuel
    /*
    if (this.login === this.password) {
      this.result = 'OK';
    } else {
      this.result = 'KO - not authorized';
    }
    */

    // v2: send event to parent
    this.credentials.emit({login: this.login, password: this.password});
  }
}
