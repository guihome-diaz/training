import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  @Output() logoutEvent = new EventEmitter<any>();

  constructor() { }

  ngOnInit(): void {
  }

  logout() {
    this.logoutEvent.emit();
  }
}
