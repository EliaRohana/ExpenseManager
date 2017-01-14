import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import {MonthlyReportListComponent} from "./monthly-report-list/monthly-report-list.component";
import {MonthlyReportApiService} from "./api/monthly-report-api.service";
import {DataGridModule} from 'primeng/primeng';
import {PanelModule} from 'primeng/primeng';
import { MonthlyReportComponent } from './monthly-report/monthly-report.component';

@NgModule({
  declarations: [
    AppComponent,
      MonthlyReportListComponent,
      MonthlyReportComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    DataGridModule,
    PanelModule
  ],
  providers: [MonthlyReportApiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
