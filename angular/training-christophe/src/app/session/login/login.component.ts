import {Component, OnInit} from '@angular/core';
import {SessionService} from '../session.service';
import {Router} from '@angular/router';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: string = null;
  pwd: string = null;

  constructor(private sessionService: SessionService, private router: Router) {
  }

  ngOnInit(): void {
    this.user = 'aaa';
    this.pwd = 'aaa';
  }

  login(form: NgForm): void {
    if (form.valid) {
      this.sessionService.login(this.user, this.pwd, () => this.router.navigate(['/']));
    }
  }
}
