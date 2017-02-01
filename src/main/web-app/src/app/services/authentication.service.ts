import {Injectable} from "@angular/core";
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

      let url = `${baseUrl}/principal`;
      return this.http.request(url, options)
        .map((response) => {
          let user = {email: response.json().email, id: response.json().id};
          localStorage.setItem('currentUser', btoa(JSON.stringify(user)));
          this.router.navigate(['reports']);
          return true;
        })
  }

  public register(newUser) {
    let url = `${baseUrl}/register`;
    let headers = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: headers});
    return this.http
        .post(url, newUser, options)
        .subscribe((response) => {
          console.log(response.status == 204)
        });
  }

  public signup(){
    localStorage.removeItem('currentUser');
    this.router.navigate(['login']);
  }

}
