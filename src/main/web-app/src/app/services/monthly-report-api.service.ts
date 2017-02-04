import {Injectable} from "@angular/core";
import {URLSearchParams} from "@angular/http";
import {MonthlyReport} from "../model/MonthlyReport";
import {Observable} from "rxjs";
import {apiUrl} from "./api-consts";
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
    params.set('userId', userId);
    return this.http.get(this.baseUrl, {search: params})
  }

}
