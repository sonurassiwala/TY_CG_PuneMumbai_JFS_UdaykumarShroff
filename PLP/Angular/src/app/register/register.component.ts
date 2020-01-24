import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HotelService } from '../hotel.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  message: string;
  error: string;
  constructor(private router: Router, private hotel: HotelService) { }

  register(registerForm: NgForm) {
    console.log(registerForm.value);
    this.hotel.userRegister({...registerForm.value, userType: 'User'}).subscribe(data => {
      console.log(data);
      if (data && data.statusCode === 201) {
        this.message = data.description;
        registerForm.reset();
        this.router.navigateByUrl('/login');
      } else if (data && data.statusCode === 401) {
        this.error = data.description;
      }
    }, err => {
      console.log(err);
    });
  }

  /* Set the width of the side navigation to 250px */
  openNav() {
    document.getElementById('mySidenav').style.width = '250px';
  }

  /* Set the width of the side navigation to 0 */
  closeNav() {
    document.getElementById('mySidenav').style.width = '0';
  }
  ngOnInit() {
  }

}
