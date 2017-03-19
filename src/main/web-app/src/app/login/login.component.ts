import {Component, OnInit} from "@angular/core";
import {FormGroup, FormControl, Validators} from "@angular/forms";
import {Router, ActivatedRoute} from "@angular/router";
import {UserService} from "../services/user.service";

@Component({
  selector: 'app-login',
  template: `
  <div class="login-container">
    <form [formGroup]="loginForm"  (ngSubmit)="login()">
      <p-panel header="Login">
      
        <div *ngIf="showError">Wrong email or password</div>
        <div class="login-field">
            <label>Username:</label>
            <input type="email" formControlName="username"  pInputText placeholder="Enter Username" class="username-input" />
        </div>
        <div class="login-field">
            <label>Password:</label>
            <input type="password" formControlName="password" pInputText placeholder="Enter Password" class="password-input" />
        </div>
        
        <div class="login-submit">
            <button pButton type="submit" class="login-button"  label="Login" [disabled]="!loginForm.valid"></button>
            <a [routerLink]="['/register']" routerLinkActive="active" class="btn btn-link register-link">Register</a>
        </div>
    </p-panel>
    </form>
</div>


  `,
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private loginForm: FormGroup;
  private username: FormControl;
  private password: FormControl;
  private router: Router;
  private authService: UserService;
  private route: ActivatedRoute;
  private showError: boolean;

  constructor(router: Router, route: ActivatedRoute, authService: UserService) {
    this.router = router;
    this.route = route;
    this.authService = authService;
  }

  ngOnInit() {
    this.username = new FormControl('', Validators.required);
    this.password = new FormControl('', Validators.compose([
      Validators.required,
      Validators.minLength(4)
    ]));
    this.loginForm = new FormGroup({
      username: this.username,
      password: this.password
    })

  }

  public login(): void{
    this.authService.authenticate(this.username.value, this.password.value).subscribe((result) => {
      // get return url from route parameters or default to '/'
      if(result){
        let returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
        this.router.navigate([returnUrl])
      }
      else{
        this.showError = true;
      }

    },
        (error)=>this.showError = true);


}

}
