import {Component} from '@angular/core';
import {SharedData} from './app-base/shared-data';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private sharedData: SharedData) {
  }

  userLogged(): boolean {
    return this.sharedData.sessionId && this.sharedData.sessionId !== '';
  }
}
