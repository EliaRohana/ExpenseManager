import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  template: `
  <div class="login-container">
    <form >
      <p-panel header="Login">
        <div class="login-field">
            <label>Username:</label>
            <input type="text" pInputText placeholder="Enter Username" class="username-input"/>
        </div>
        <div class="login-field">
            <label>Password:</label>
            <input type="password" pInputText placeholder="Enter Password" class="password-input"/>
        </div>
        
        <div class="login-submit">
            <button pButton type="button" class="login-button"  label="Submit"></button>
        </div>
    </p-panel>
    </form>
</div>


  `,
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
