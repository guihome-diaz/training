import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'training';
  isLogged: boolean;
  loginMessage: string;

  // Method call at every rendering
  ngOnInit() {
    this.isLogged = false;
  }

  onLogin(login) {
    this.isLogged = true;
    this.loginMessage = 'Welcome to this application'
  }

  logout() {
    this.isLogged = false;
    this.loginMessage = undefined;
  }

}
