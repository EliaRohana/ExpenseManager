import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {AppComponent} from "./app.component";
import {MonthlyReportListComponent} from "./monthly-report-list/monthly-report-list.component";
import {MonthlyReportApiService} from "./services/monthly-report-api.service";
import {
  DataGridModule,
  PanelModule,
  InputTextModule,
  PasswordModule,
  ButtonModule,
  FieldsetModule
} from "primeng/primeng";
import {MonthlyReportComponent} from "./monthly-report/monthly-report.component";
import {LoginComponent} from "./login/login.component";
import {MaterialModule} from "@angular/material";
import {AppRoutingModule} from "./app-routing/app-routing.module";
import {AuthGuard} from "./auth-guard";
import {AuthenticationService} from "./services/authentication.service";
import {RegisterComponent} from "./register/register.component";

@NgModule({
  declarations: [
    AppComponent,
      MonthlyReportListComponent,
      MonthlyReportComponent,
      LoginComponent,
      RegisterComponent
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
    FieldsetModule,
    [MaterialModule.forRoot()]
  ],
  providers: [MonthlyReportApiService, AuthGuard ,AuthenticationService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
