import {Component, OnInit} from '@angular/core';
import {SharedData} from '../shared-data';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  constructor(public sharedData: SharedData) {
  }

  ngOnInit(): void {
  }
}
