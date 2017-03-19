import {Injectable} from "@angular/core";
import {Http, Request, RequestOptionsArgs, Response} from "@angular/http";
import {Observable} from "rxjs";

@Injectable()
export class HttpClientService {
  private http: Http;

  constructor(http: Http) {
    this.http = http;
  }

  request(url: string | Request, options?: RequestOptionsArgs): Observable<any>{
    this.setDefaultHeaders(options);
    return this.http.request(url, options).map(HttpClientService.extractData).catch(HttpClientService.handleError)
  }

  private setDefaultHeaders(options: RequestOptionsArgs) {
    this.setDefaultHeaders(options);
    options.headers.append('X-Requested-With', 'XMLHttpRequest');// this will prevent browser popup
  }
  /**
   * Performs a request with `get` http method.
   */
  get(url: string, options?: RequestOptionsArgs): Observable<any>{
    this.setDefaultHeaders(options);
    return this.http.get(url, options).map(HttpClientService.extractData).catch(HttpClientService.handleError)
  }
  /**
   * Performs a request with `post` http method.
   */
  post(url: string, body: any, options?: RequestOptionsArgs): Observable<any>{
    this.setDefaultHeaders(options);
    return this.http.post(url, body, options).map(HttpClientService.extractData).catch(HttpClientService.handleError)
  }
  /**
   * Performs a request with `put` http method.
   */
  put(url: string, body: any, options?: RequestOptionsArgs): Observable<any>{
    this.setDefaultHeaders(options);
    return this.http.put(url, body, options).map(HttpClientService.extractData).catch(HttpClientService.handleError)
  }
  /**
   * Performs a request with `delete` http method.
   */
  delete(url: string, options?: RequestOptionsArgs): Observable<any>{
    this.setDefaultHeaders(options);
    return this.http.delete(url, options).map(HttpClientService.extractData).catch(HttpClientService.handleError)
  }
  /**
   * Performs a request with `head` http method.
   */
  head(url: string, options?: RequestOptionsArgs): Observable<any>{
    this.setDefaultHeaders(options);
    return this.http.head(url, arguments)
  }
  /**
   * Performs a request with `options` http method.
   */
  options(url: string, options?: RequestOptionsArgs): Observable<any>{
    this.setDefaultHeaders(options);
    return this.http.options(url, options);
  }


  private static extractData(res: Response) {
    try {
      return res.json();
    } catch (e) {
      return {}
    }
  }

  private static handleError (error: Response | any) {
    // In a real world app, we might use a remote logging infrastructure
    let errMsg: string;
    if(error._body)//todo check why error object is not a response
      return Observable.throw(error._body);
    else if (error instanceof Response) {
      let body;
      try {
        body = error.json();
      } catch (e) {
        body = error.text();
      }
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }





}
