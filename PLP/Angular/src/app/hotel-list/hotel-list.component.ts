import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { Hotel } from '../hotel';
import { Router } from '@angular/router';

@Component({
  selector: 'app-hotel-list',
  templateUrl: './hotel-list.component.html',
  styleUrls: ['./hotel-list.component.css']
})
export class HotelListComponent implements OnInit {

  message: string;
  error: string;
  hotelList = this.hotelService.hotels;
  hotels: any[];
  selectedHotel = this.hotelList[0];
  constructor(private hotelService: HotelService, private router: Router) {
    const userDetails = JSON.parse(localStorage.getItem('key'));
    this.hotelService.bookingRoomDetails.userId = userDetails.userId;
    this.hotelService.getShowAllHotel();
  }

  selectHotel(hotel: Hotel) {
    console.log(hotel);
    this.selectedHotel = hotel;
    this.hotelService.userSelectedHotel(hotel);
    console.log(hotel);
  }

  isAdmin(): boolean {
    const userDetails = JSON.parse(localStorage.getItem('key'));
    console.log(userDetails);
    if (userDetails.userType === 'Admin') {
      return true;
    } else {
      return false;
    }
  }

  isUser(): boolean {
    const userDetails = JSON.parse(localStorage.getItem('key'));
    console.log(userDetails);
    if (userDetails.userType === 'User') {
      return true;
    } else {
      return false;
    }
  }

  deleteHotel(hotel) {
    this.hotelService.deleteHotel(hotel).subscribe(response => {
      console.log(response);
      if (response.statusCode === 201) {
        this.message = response.description;
      } else if (response.statusCode === 401) {
        this.message = response.description;
      }
      this.hotelService.getShowAllHotel();
      this.router.navigateByUrl('/hotel-list');
    },
      err => {
        console.log(err);
      });
  }

  bookHotel() {
    this.router.navigateByUrl('/booking-form');
  }

  back() {
    this.router.navigateByUrl('/navbar');
  }
  ngOnInit() {
  }

}
