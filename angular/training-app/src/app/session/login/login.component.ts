import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';
import {SessionService} from "../session.service";
import {ActivatedRoute, Router} from "@angular/router";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login: string;
  password: string;
  @Input()  defaultLogin: string;

  constructor(public sessionService: SessionService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    // This method is called every time the component is render
    //  not just when the component is created!
    if (this.defaultLogin) {
      this.login = this.defaultLogin;
    } else {
      this.defaultLogin = '';
    }
  }

  validateCredentials() {
    // v1: check manuel
    // v2: send event to parent (login + password)
    // v3: send event to parent, only login, if credentials are ok
    // v4: adjust common shared data
    // v5: call the dedicated service
    // v6: redirect user to default page on success
    // v7: use NG form
    this.sessionService.login(this.login, this.password, () => { this.router.navigate(["/dashboard"] )});
  }
}
