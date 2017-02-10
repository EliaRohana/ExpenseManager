import {Injectable} from "@angular/core";
import {URLSearchParams, Headers} from "@angular/http";
import {MonthlyReport} from "../model/MonthlyReport";
import {Observable} from "rxjs";
import {apiUrl} from "../core/ap-consts";
import {HttpClientService} from "../core/http-client.service";

@Injectable()
export class MonthlyReportApiService {
  private http: HttpClientService;
  private baseUrl: string = apiUrl + '/monthlyReport';

  constructor(http: HttpClientService) {
    this.http = http;
  }

  public getMonthlyReports(userId): Observable<MonthlyReport[]> {
    let params = new URLSearchParams();
    let headers = new Headers({'Content-Type': 'application/json'});
    params.set('userId', userId);
    return this.http.get(this.baseUrl, {search: params, withCredentials: true})
  }

}
