import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions} from "@angular/http";
import {Router} from "@angular/router";
import {Observable} from "rxjs";
import {baseUrl} from "./api-consts";

@Injectable()
export class AuthenticationService {
  private http: Http;
  private router: Router;

  constructor(http: Http, router: Router) {
    this.http = http;
    this.router = router;
  }

  public authenticate(username, password): Observable<any>{
    let headers = new Headers({ 'Content-Type': 'application/json' });
    headers.append("Authorization", "Basic " + btoa(username + ":" + password));
    let options = new RequestOptions({headers: headers});

    return this.http.request(`${baseUrl}/principal`, options)
        .map((response) => {
          localStorage.setItem('currentUser', response.json());
          this.router.navigate(['reports']);
          return true;
        })
  }
  public signup(){
    localStorage.removeItem('currentUser');
    this.router.navigate(['login']);
  }

}
