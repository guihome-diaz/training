import {Component, OnInit} from '@angular/core';
import {SharedData} from "../shared-data";
import {Router} from "@angular/router";

@Component({
  selector: 'app-status-bar',
  templateUrl: './status-bar.component.html',
  styleUrls: ['./status-bar.component.css']
})
export class StatusBarComponent implements OnInit {

  userStatus: string;

  constructor(public sharedData: SharedData, public router: Router) { }

  ngOnInit(): void {
  }

  viewDashboard() {
    this.router.navigate(["/dashboard"]);
  }

}
