import {Component, OnInit} from '@angular/core';
import {SharedData} from '../shared-data';

@Component({
  selector: 'app-menu-bar',
  templateUrl: './menu-bar.component.html',
  styleUrls: ['./menu-bar.component.css']
})
export class MenuBarComponent implements OnInit {

  constructor(public sharedData: SharedData) {
  }

  ngOnInit(): void {
  }
}
