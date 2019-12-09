import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormGroup, FormControl, Validators, NgForm } from '@angular/forms';
import { CustomValidator } from './custom.validator';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit, OnDestroy {
  

  constructor() {
    console.log('Register Component constructor is running');
  }

  get email(){
    return this.registerForm.get('email');
  }

  get password(){
    return this.registerForm.get('password');
  }

  registerForm = new FormGroup({
    email: new FormControl('', [
      Validators.required,
      Validators.email,
      Validators.minLength(8),
      CustomValidator.noSpace
    ]),
    password: new FormControl('',[
      Validators.required,
      Validators.minLength(8)
    ])
  });
  printForm(registerForm : NgForm){
    console.log(registerForm);
  }


  ngOnInit() {
    console.log('Component initialised');
  }

  ngOnDestroy() {
    console.log('register component destroyed');
  }

}
