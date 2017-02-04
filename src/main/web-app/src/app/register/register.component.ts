import {Component, OnInit} from "@angular/core";
import {FormGroup, FormControl, Validators} from "@angular/forms";
import {UserService} from "../services/user.service";
import {Message} from "primeng/components/common/api";
import {Router} from "@angular/router";

const SUCCESS_MSG_TIMEOUT = 5000;

@Component({
  selector: 'app-register',
  templateUrl: "register.component.html",
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {


  private registerForm: FormGroup;
  private formMsgs: Message[] = [];
  private userService: UserService;
  private router: Router;

  constructor(userService: UserService, router: Router) {
    this.userService = userService;
    this.router = router;
    this.registerForm = new FormGroup({
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
      passwordConfirm: new FormControl('', Validators.required)
    });
  }

  ngOnInit() {

  }

  register(){
    this.userService
        .register(this.registerForm.value)
        .subscribe(
            (success)=>{
              this.formMsgs.push({severity:'success', summary:'Registration Completed Successfully'});
              //wait until success message disappear
              setTimeout(()=> this.router.navigate(['/login']), SUCCESS_MSG_TIMEOUT);
            },
            (error) => {
              this.formMsgs.push({severity:'error', summary:'Registration error', detail: error});
            });
  }

}
