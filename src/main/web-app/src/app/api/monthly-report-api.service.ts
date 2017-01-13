import { Injectable } from '@angular/core';
import {Http, URLSearchParams, Response} from "@angular/http";
import {MonthlyReport} from "../model/MonthlyReport";
import {Observable} from "rxjs";

@Injectable()
export class MonthlyReportApiService {
  private http: Http;
  private baseUrl: string = 'http://localhost:8080/monthlyReport';

  constructor(http: Http) {
    this.http = http;
  }

  public getMonthlyReports(userId): Observable<MonthlyReport[]> {
    let params = new URLSearchParams();
    params.set('userId', userId);
    return this.http.get(this.baseUrl, {search: params})
        .map(this.extractData)
        .catch(this.handleError);
  }

  private extractData(res: Response) {
    let body = res.json();
    return body || { };
  }

  private handleError (error: Response | any) {
    // In a real world app, we might use a remote logging infrastructure
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }

}
