import { Component, OnInit } from '@angular/core';
import {MonthlyReportApiService} from "../api/monthly-report-api.service";
import {MonthlyReport} from "../model/MonthlyReport";

@Component({
  selector: 'app-monthly-report-list',
  template: `
<h2>Monthly Reports</h2>
<app-monthly-report *ngFor="let report of monthlyReports"></app-monthly-report>
`,
  styleUrls: ['./monthly-report-list.component.css']
})
export class MonthlyReportListComponent implements OnInit {
  private api: MonthlyReportApiService;
  private monthlyReports: MonthlyReport[];
  private apiErrorMsg : string;

  constructor(api: MonthlyReportApiService) {
    this.api = api;
  }

  ngOnInit() {
    this.monthlyReports = [new MonthlyReport, new MonthlyReport, new MonthlyReport,
      new MonthlyReport, new MonthlyReport, new MonthlyReport,
      new MonthlyReport, new MonthlyReport, new MonthlyReport];
    // this.api
    //     .getMonthlyReports('5873f0dce81a9f1930905fbd')
    //     .subscribe(
    //         reports => this.monthlyReports = reports,
    //         error => this.apiErrorMsg = error)
  }

}
