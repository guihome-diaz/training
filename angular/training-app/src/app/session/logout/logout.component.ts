import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {SessionService} from "../session.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(public sessionService: SessionService, private router: Router) { }

  ngOnInit(): void {
  }

  logout() {
    this.sessionService.logout(() => {this.router.navigate(["/login"])});
  }
}
