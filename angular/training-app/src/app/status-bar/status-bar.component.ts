import { Component, OnInit } from '@angular/core';
import {SharedData} from "../shared-data";

@Component({
  selector: 'app-status-bar',
  templateUrl: './status-bar.component.html',
  styleUrls: ['./status-bar.component.css']
})
export class StatusBarComponent implements OnInit {

  userStatus: string;

  constructor(public sharedData: SharedData) { }

  ngOnInit(): void {
  }

}
