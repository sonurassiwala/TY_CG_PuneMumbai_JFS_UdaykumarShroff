import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-visitor-hotel-details',
  templateUrl: './visitor-hotel-details.component.html',
  styleUrls: ['./visitor-hotel-details.component.css']
})
export class VisitorHotelDetailsComponent implements OnInit {

  roomDetails = [];
  selectedHotel = [];

  constructor(private hotelService: HotelService, private router: Router) {
    this.selectedHotel = this.hotelService.visitorHotelData;
   }

  bookRoom(room) {
    if (this.hotelService.isLoggedIn()) {
      this.hotelService.userSelectedRoom(room);
    } else {
      this.router.navigateByUrl('/login');
    }
  }

  RoomDetails(hotelId) {
    this.hotelService.getHotelRoomDetails(hotelId).subscribe(response => {
      console.log(response.roomList);
      this.roomDetails = response.roomList;
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
