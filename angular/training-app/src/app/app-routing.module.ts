import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AboutComponent} from "./about/about.component";
import {LoginComponent} from "./session/login/login.component";
import {DashboardComponent} from "./dashboard/dashboard.component";
import {ContactMgrComponent} from "./contact/contact-mgr/contact-mgr.component";
import {ActionableWhenLoggedIn} from "./actionable-when-logged-in.service";

const routes: Routes = [
  // {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'about', component: AboutComponent},
  {path: 'login', component: LoginComponent},
  {path: 'dashboard', component: DashboardComponent, canActivate: [ActionableWhenLoggedIn]},
  {path: 'contact', component: ContactMgrComponent, canActivate: [ActionableWhenLoggedIn]},
  {path: '**', redirectTo: '/dashboard'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
