import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-all-hotels',
  templateUrl: './show-all-hotels.component.html',
  styleUrls: ['./show-all-hotels.component.css']
})
export class ShowAllHotelsComponent implements OnInit {

  message: string;
  error: string;

  hotels: any[];

  constructor(private hotel: HotelService, private router: Router) {
    this.hotel.getShowAllHotel();
  }

  deleteHotel(hotel) {
    this.hotel.deleteHotel(hotel).subscribe(response => {
      console.log(response);
      console.log('Deleted One Hotel');
      this.hotels.splice(this.hotels.indexOf(hotel), 1);
    },
      err => {
        console.log(err);
      });
  }

  updateHotel() {

  }

  bookHotel() {
    this.router.navigateByUrl('/booking-form');
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
  ngOnInit() {
  }

}
