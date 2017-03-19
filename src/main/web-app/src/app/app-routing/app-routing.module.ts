import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {LoginComponent} from "../login/login.component";
import {MonthlyReportListComponent} from "../monthly-report-list/monthly-report-list.component";
import {AuthGuard} from "../auth-guard";
import {RegisterComponent} from "../register/register.component";

const routes: Routes = [
  {path: '',  component: RegisterComponent, canActivate: [AuthGuard]},
  { path: 'login',  component: LoginComponent },
  { path: 'register',  component: RegisterComponent },
  { path: 'reports', component:  MonthlyReportListComponent, canActivate: [AuthGuard]},
  ];


@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
