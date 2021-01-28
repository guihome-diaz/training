import {Component, OnInit} from '@angular/core';
import {SharedData} from "./shared-data";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'training';
  isLogged: boolean;
  welcomeMessage: string;


  constructor(public sharedData: SharedData) {
  }

  // Method call at every rendering
  ngOnInit() {
    this.isLogged = false;
  }

  onLogin(event) {
    this.isLogged = true;
    this.welcomeMessage = 'Welcome to this application, ' + event.login;
  }

  onLogout() {
    this.isLogged = false;
    this.welcomeMessage = undefined;
  }

}
