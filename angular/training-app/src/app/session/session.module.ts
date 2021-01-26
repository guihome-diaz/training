import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {LoginComponent} from "./login/login.component";
import { LogoutComponent } from './logout/logout.component';



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
    CommonModule
  ]
})
export class SessionModule { }
