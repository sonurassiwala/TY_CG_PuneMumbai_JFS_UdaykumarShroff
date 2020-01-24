import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HotelService } from '../hotel.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  message: any;

  constructor(private router: Router, private hotel: HotelService) { }

  loginForm(form: NgForm) {
    console.log(form);
    this.hotel.userLogin(form.value).subscribe(data => {
      console.log(data);
      if (data && data.statusCode === 201) {
        localStorage.setItem('key', JSON.stringify(data.userBean));
        this.router.navigateByUrl('/front-page');
      } else if (data && data.statusCode === 401) {
        this.message = data.description;
        alert(this.message);
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
