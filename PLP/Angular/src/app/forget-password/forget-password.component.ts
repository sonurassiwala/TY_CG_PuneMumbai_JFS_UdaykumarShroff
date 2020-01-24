import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HotelService } from '../hotel.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-forget-password',
  templateUrl: './forget-password.component.html',
  styleUrls: ['./forget-password.component.css']
})
export class ForgetPasswordComponent implements OnInit {

  error: string;

  constructor(private router: Router, private hotel: HotelService) { }

  resetPasswordForm(passwordResetForm: NgForm) {
    console.log(passwordResetForm);
    this.hotel.forgotPassword(passwordResetForm.value).subscribe(data => {
      console.log(data);
      if (data && data.statusCode === 201) {
        localStorage.setItem('key', JSON.stringify(data));
        this.router.navigateByUrl('/');
      } else if (data && data.statusCode === 401) {
        this.error = data.description;
      }
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
