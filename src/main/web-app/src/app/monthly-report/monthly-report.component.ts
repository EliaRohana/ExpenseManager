import {Component, OnInit, Input} from '@angular/core';
import {MonthlyReport} from "../model/MonthlyReport";

@Component({
  selector: 'app-monthly-report',
  template: `
        <div  class="ui-g-4 ui-md-3">
              <p-panel class="report-panel" [header]="monthlyReport.name" >
                  <div class="car-detail">{{monthlyReport.month  + "/" + monthlyReport.year}}</div>
              </p-panel>
          </div>
  `,
  styleUrls: ['./monthly-report.component.css']
})
export class MonthlyReportComponent implements OnInit {

  @Input()
  private monthlyReport: MonthlyReport;

  constructor() { }

  ngOnInit() {
  }

}
