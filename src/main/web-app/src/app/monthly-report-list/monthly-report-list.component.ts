import {Component, OnInit} from "@angular/core";
import {MonthlyReportApiService} from "../services/monthly-report-api.service";
import {MonthlyReport} from "../model/MonthlyReport";

@Component({
  selector: 'app-monthly-report-list',
  template: `
<h2>Monthly Reports</h2>
<h3>{{monthlyReports | json}}</h3>
<h4>{{apiErrorMsg}}</h4>
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
    let user = JSON.parse(atob(localStorage.getItem('currentUser')));
    this.api
        .getMonthlyReports(user.id)
        .subscribe(
            reports => {
              console.log(reports)
              this.monthlyReports = reports},
            error => this.apiErrorMsg = error)
  }

}
