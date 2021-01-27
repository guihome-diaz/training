import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {SharedData} from "../../shared-data";

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  @Output() logoutEvent = new EventEmitter<any>();

  constructor(public sharedData: SharedData) { }

  ngOnInit(): void {
  }

  logout() {
    this.sharedData.sessionId = undefined;
    this.logoutEvent.emit();
  }
}
