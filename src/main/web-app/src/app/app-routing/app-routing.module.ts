import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "../login/login.component";
import {MonthlyReportListComponent} from "../monthly-report-list/monthly-report-list.component";
import {AuthGuard} from "../auth-guard";

const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch:'full'},
  { path: 'login',  component: LoginComponent },
  { path: 'reports', component:  MonthlyReportListComponent, canActivate: [AuthGuard]},
  ];


@NgModule({
  imports: [ RouterModule.forRoot(routes, { useHash: true }) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
