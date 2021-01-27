import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {SessionService} from "../session.service";

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(public sessionService: SessionService) { }

  ngOnInit(): void {
  }

  logout() {
    this.sessionService.logout();
  }
}
