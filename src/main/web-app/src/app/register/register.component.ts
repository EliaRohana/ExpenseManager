import {Component, OnInit} from "@angular/core";
import {FormGroup, FormControl, Validators} from "@angular/forms";
import {AuthenticationService} from "../services/authentication.service";

@Component({
  selector: 'app-register',
  templateUrl: "register.component.html",
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;
  private userService: AuthenticationService;

  constructor(userService: AuthenticationService) {
    this.userService = userService;
    this.registerForm = new FormGroup({
      username: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
      passwordConfirm: new FormControl('', Validators.required)
    });
  }

  ngOnInit() {

  }

  register(){
    this.userService.register(this.registerForm.value);
  }

}
