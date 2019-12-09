import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  error = null;

  constructor(private auth: AuthService, private router: Router) { }

  loginUser(loginForm: NgForm) {
    this.error = null;
    this.auth.login(loginForm.value).subscribe(response => {
      console.log(response);
      loginForm.reset();
      if (response.registered) {
        const user = JSON.stringify(response);
        localStorage.setItem('token', user);
        this.router.navigateByUrl('/about');
      }
    }, err => {
      console.log(err);
      this.error = err.error.error.message;
      loginForm.reset();
    });
  }

  ngOnInit() {
  }

}
