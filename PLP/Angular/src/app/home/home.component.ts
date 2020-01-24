import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { HotelService } from '../hotel.service';
import { Hotel } from '../hotel';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  hotels = [];
  hotelList = this.hotelService.hotels;
  selectedHotel = this.hotelList[0];

  constructor(private router: Router, private hotelService: HotelService) {
    this.hotelService.getShowAllHotel();
  }

  // searchHotels(location) {
  //   console.log(location);
  //   this.hotelService.searchHotel(location);
  //   this.router.navigateByUrl('/hotel-list');
  // }

  selectHotel(hotel: Hotel) {
    console.log(hotel);
    this.selectedHotel = hotel;
    this.hotelService.getVisitorHotelData(hotel);
    console.log(hotel);
  }


  isUser(): boolean {
    const userDetails = JSON.parse(localStorage.getItem('key'));
    if (userDetails.userType === 'User') {
      return true;
    } else {
      return false;
    }
  }

  isManager(): boolean {
    const userDetails = JSON.parse(localStorage.getItem('key'));
    if (userDetails.userType === 'Manager') {
      return true;
    } else {
      return false;
    }
  }


  isAdmin(): boolean {
    const userDetails = JSON.parse(localStorage.getItem('key'));
    if (userDetails.userType === 'Admin') {
      return true;
    } else {
      return false;
    }
  }

  isLoggedIn(): boolean {
    const userDetails = JSON.parse(localStorage.getItem('key'));
    if (userDetails) {
      return true;
    } else {
      return false;
    }
  }

  ngOnInit() {
  }

}
