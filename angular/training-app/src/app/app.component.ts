import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'training';
  result: string;

  onCredentials(credentials) {
    this.result = (credentials.login === credentials.password ? 'Success: access granted' : 'Error: not allowed');
  }
}
