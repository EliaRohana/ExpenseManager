import { Component, OnInit } from '@angular/core';
import {FormGroup, FormControl, Validators} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  template: `
  <div class="login-container">
    <form [formGroup]="loginForm"  (ngSubmit)="login()">
      <p-panel header="Login">
      
        <div class="login-field">
            <label>Username:</label>
            <input type="text" formControlName="username"  pInputText placeholder="Enter Username" class="username-input" />
        </div>
        <div class="login-field">
            <label>Password:</label>
            <input type="password" formControlName="password" pInputText placeholder="Enter Password" class="password-input" />
        </div>
        
        <div class="login-submit">
            <button pButton type="submit" class="login-button"  label="Submit" [disabled]="!loginForm.valid"></button>
        </div>
    </p-panel>
    </form>
</div>


  `,
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private loginForm: FormGroup;
  private router: Router;

  constructor(router: Router) {
    this.router = router;
  }

  ngOnInit() {
    this.loginForm = new FormGroup({
      username: new FormControl('', Validators.required),
      password: new FormControl('', Validators.compose([
          Validators.required,
          Validators.minLength(8)
      ]))
    })

  }

  public login(): void{
    console.log('login')
    this.router.navigate(['reports'])

}

}
