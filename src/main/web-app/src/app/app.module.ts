import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import {MonthlyReportListComponent} from "./monthly-report-list/monthly-report-list.component";
import {MonthlyReportApiService} from "./services/monthly-report-api.service";
import {DataGridModule} from 'primeng/primeng';
import {PanelModule} from 'primeng/primeng';
import { MonthlyReportComponent } from './monthly-report/monthly-report.component';
import { LoginComponent } from './login/login.component';
import { MaterialModule } from '@angular/material';
import {InputTextModule} from 'primeng/primeng';
import {PasswordModule} from 'primeng/primeng';
import {ButtonModule} from 'primeng/primeng';
import {AppRoutingModule} from "./app-routing/app-routing.module";
import {AuthGuard} from "./auth-guard";
import {AuthenticationService} from "./services/authentication.service";

@NgModule({
  declarations: [
    AppComponent,
      MonthlyReportListComponent,
      MonthlyReportComponent,
      LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    DataGridModule,
    PanelModule,
    InputTextModule,
    PasswordModule ,
    ButtonModule,
    AppRoutingModule,
    [MaterialModule.forRoot()]
  ],
  providers: [MonthlyReportApiService, AuthGuard ,AuthenticationService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
