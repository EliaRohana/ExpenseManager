import { Component, OnInit } from '@angular/core';
import {MonthlyReportApiService} from "../api/monthly-report-api.service";
import {MonthlyReport} from "../model/MonthlyReport";

@Component({
  selector: 'app-monthly-report-list',
  template: `
<h2>Monthly Reports</h2>
  <p-dataGrid [value]="monthlyReports" >
      <template let-report>
        <app-monthly-report [monthlyReport]="report"></app-monthly-report>
      </template>
  </p-dataGrid>
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
    // this.monthlyReports = [new MonthlyReport, new MonthlyReport, new MonthlyReport,
    //   new MonthlyReport, new MonthlyReport, new MonthlyReport,
    //   new MonthlyReport, new MonthlyReport, new MonthlyReport];
    this.api
        .getMonthlyReports('58789303e81a9f1f68f0a802')
        .subscribe(
            reports => {
              console.log(reports)
              this.monthlyReports = reports},
            error => this.apiErrorMsg = error)
  }

}
