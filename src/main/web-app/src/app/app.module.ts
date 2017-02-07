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
import {AppRoutingModule} from "./app-routing/app-routing.module";
import {AuthGuard} from "./auth-guard";
import {UserService} from "./services/user.service";
import {RegisterComponent} from "./register/register.component";
import {CustomFormsModule} from "ng2-validation";
import {GrowlModule} from "primeng/components/growl/growl";
import {CoreModule} from "./core/core.module";

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
    CoreModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    DataGridModule,
    PanelModule,
    InputTextModule,
    PasswordModule ,
    ButtonModule,
    GrowlModule,
    AppRoutingModule,
    FieldsetModule,
    CustomFormsModule,
  ],
  providers: [MonthlyReportApiService, AuthGuard ,UserService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
