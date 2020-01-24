import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { User } from '../user';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  message: string;

  selectedUserData: User = {
    userId: null,
    userName: null,
    email: null,
    phoneNumber: null,
    nationality: null,
    gender: null,
    password: null,
    userType: null
  };

  userId;

  constructor(private hotelService: HotelService, private router: Router) {
    const userDetails = JSON.parse(localStorage.getItem('key'));
    this.userId = userDetails.userId;
    this.hotelService.getProfileData(this.userId);
  }

  selectData(user: User) {
    console.log(user);
    this.selectedUserData.userId = user.userId;
    this.selectedUserData.userName = user.userName;
    this.selectedUserData.email = user.email;
    this.selectedUserData.phoneNumber = user.phoneNumber;
    this.selectedUserData.nationality = user.nationality;
    this.selectedUserData.gender = user.gender;
    this.selectedUserData.password = user.password;
    this.selectedUserData.userType = user.userType;
  }

  submitForm(form: NgForm) {
    console.log(form.value);
    this.hotelService.updateProfileData(form.value).subscribe(response => {
      console.log(response);
      if (response.statusCode === 201) {
        this.message = response.description;
        form.reset();
      } else if (response.statusCode === 401) {
        this.message = response.description;
      }
      this.hotelService.getProfileData(this.userId);
    }, err => {
      console.log(err);
    });
  }


  ngOnInit() {
  }

}
