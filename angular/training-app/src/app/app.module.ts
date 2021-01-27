import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {SessionModule} from "./session/session.module";
import {SharedData} from "./shared-data";
import { StatusBarComponent } from './status-bar/status-bar.component';
import { FooterBarComponent } from './footer-bar/footer-bar.component';

@NgModule({
  declarations: [
    AppComponent,
    StatusBarComponent,
    FooterBarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    // Import custom module to perform login
    SessionModule
  ],
  providers: [SharedData],
  bootstrap: [AppComponent]
})
export class AppModule { }
