import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {LoginComponent} from './login/login.component';
import {LogoutComponent} from './logout/logout.component';
import {HttpClientModule} from '@angular/common/http';
import {SessionService} from './session.service';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    LoginComponent,
    LogoutComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule
  ],
  exports: [
    LoginComponent,
    LogoutComponent
  ],
  providers: [
    SessionService
  ]
})
export class SessionModule {
}
