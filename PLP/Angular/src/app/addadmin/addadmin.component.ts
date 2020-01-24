import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HotelService } from '../hotel.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-addadmin',
  templateUrl: './addadmin.component.html',
  styleUrls: ['./addadmin.component.css']
})
export class AddadminComponent implements OnInit {

  message: string;
  error: string;
  constructor(private router: Router, private hotel: HotelService) { }

  register(registerForm: NgForm) {
    console.log(registerForm.value);
    this.hotel.userRegister({...registerForm.value, userType: 'Manager'}).subscribe(data => {
      console.log(data);
      if (data && data.statusCode === 201) {
        this.message = data.description;
        alert(this.message);
      } else if (data && data.statusCode === 401) {
        this.message = data.description;
        alert(this.message);
      }
      registerForm.reset();
      this.router.navigateByUrl('/show-all-managers');
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
