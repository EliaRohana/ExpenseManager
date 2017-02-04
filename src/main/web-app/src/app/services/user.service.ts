import {Injectable} from "@angular/core";
import {Headers, RequestOptions, Response} from "@angular/http";
import {Router} from "@angular/router";
import {Observable} from "rxjs";
import {baseUrl} from "./api-consts";
import {HttpClientService} from "../core/http-client.service";

@Injectable()
export class UserService {
  private http: HttpClientService;
  private router: Router;

  constructor(http: HttpClientService, router: Router) {
    this.http = http;
    this.router = router;
  }

  public authenticate(username, password): Observable<any>{
    let headers = new Headers({ 'Content-Type': 'application/json' });
    headers.append("Authorization", "Basic " + btoa(username + ":" + password));
    let options = new RequestOptions({headers: headers});

      let url = `${baseUrl}/principal`;
      return this.http.request(url, options)
        .map((response) => {
          let user = {email: response.email, id: response.id};
          localStorage.setItem('currentUser', btoa(JSON.stringify(user)));
          this.router.navigate(['reports']);
          return true;
        })
  }

  public register(newUser): Observable<Response> {
    let url = `${baseUrl}/register`;
    let headers = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: headers});
    return this.http.post(url, newUser, options)
  }

  public signup(){
    localStorage.removeItem('currentUser');
    this.router.navigate(['login']);
  }

}
