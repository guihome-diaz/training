import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {SessionModule} from './session/session.module';
import {AppBaseModule} from './app-base/app-base.module';
import {SharedData} from './app-base/shared-data';
import {ContactModule} from './contact/contact.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SessionModule,
    AppBaseModule,
    ContactModule
  ],
  providers: [
    SharedData
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
