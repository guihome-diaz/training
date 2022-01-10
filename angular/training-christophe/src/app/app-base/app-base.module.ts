import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FooterComponent} from './footer/footer.component';
import {MenuBarComponent} from './menu-bar/menu-bar.component';
import {SessionModule} from '../session/session.module';
import { AboutComponent } from './about/about.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import {RouterModule} from '@angular/router';

@NgModule({
  declarations: [
    FooterComponent,
    MenuBarComponent,
    AboutComponent,
    DashboardComponent
  ],
  imports: [
    CommonModule,
    SessionModule,
    RouterModule
  ],
  exports: [
    FooterComponent,
    MenuBarComponent
  ]
})
export class AppBaseModule {
}
