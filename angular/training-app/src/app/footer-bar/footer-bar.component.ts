import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer-bar',
  templateUrl: './footer-bar.component.html',
  styleUrls: ['./footer-bar.component.css']
})
export class FooterBarComponent implements OnInit {

  applicationVersion: string;

  constructor() { }

  ngOnInit(): void {
    this.applicationVersion = '2021 (c) - Oxiane training ; Student work';
  }

}
