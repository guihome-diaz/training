import { Component, OnInit } from '@angular/core';
import {SharedData} from "../shared-data";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private sharedData: SharedData) { }

  ngOnInit(): void {
    // success display => clear error
    this.sharedData.clearError();
  }

}
