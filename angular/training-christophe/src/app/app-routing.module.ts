import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DashboardComponent} from './app-base/dashboard/dashboard.component';
import {ContactComponent} from './contact/contact/contact.component';
import {AboutComponent} from './app-base/about/about.component';
import {LoginComponent} from './session/login/login.component';
import {LoggedInGuard} from './logged-in.guard';
import {ContactDetailComponent} from './contact/contact-detail/contact-detail.component';

const routes: Routes = [
  {path: 'dashboard', component: DashboardComponent, canActivate: [LoggedInGuard]},
  {path: 'contacts', component: ContactComponent, canActivate: [LoggedInGuard]},
  {path: 'edit/:id', component: ContactDetailComponent, canActivate: [LoggedInGuard]},
  {path: 'about', component: AboutComponent},
  {path: 'login', component: LoginComponent},
  {path: '**', redirectTo: '/dashboard'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
