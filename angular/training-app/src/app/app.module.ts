import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {SessionModule} from "./session/session.module";
import {SharedData} from "./shared-data";
import { StatusBarComponent } from './status-bar/status-bar.component';
import { FooterBarComponent } from './footer-bar/footer-bar.component';
import {ContactModule} from "./contact/contact.module";
import { DashboardComponent } from './dashboard/dashboard.component';
import { AboutComponent } from './about/about.component';
import {NoopAnimationsModule} from "@angular/platform-browser/animations";

@NgModule({
  declarations: [
    AppComponent,
    StatusBarComponent,
    FooterBarComponent,
    DashboardComponent,
    AboutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    // Import custom module to perform login
    SessionModule,
    ContactModule,
    // Prime NG requires animations
    NoopAnimationsModule
  ],
  providers: [SharedData],
  bootstrap: [AppComponent]
})
export class AppModule { }
