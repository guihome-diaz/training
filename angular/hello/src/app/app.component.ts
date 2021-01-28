import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'hello';
  testVariable = 'Guillaume Test';
  counter=0;
  incrementCounter() {
    this.counter++;
  }
}
