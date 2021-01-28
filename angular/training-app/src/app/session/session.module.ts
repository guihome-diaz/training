import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {LoginComponent} from "./login/login.component";
import { LogoutComponent } from './logout/logout.component';
import {SessionService} from "./session.service";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";



@NgModule({
  // List available component(s)
  declarations: [
    LoginComponent,
    LogoutComponent
  ],
  // Let others use these components
  exports:[
    LoginComponent,
    LogoutComponent
  ],
  // Required dependencies
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule
  ],
  // Public service
  providers: [
    SessionService
  ]
})
export class SessionModule { }
