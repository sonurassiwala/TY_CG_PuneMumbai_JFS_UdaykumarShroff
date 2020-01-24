import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-manager-hotel',
  templateUrl: './manager-hotel.component.html',
  styleUrls: ['./manager-hotel.component.css']
})
export class ManagerHotelComponent implements OnInit {

  selectedHotel = [];
  roomDetails = [];

  constructor(private hotelService: HotelService) {
    // this.selectedHotel = this.hotelService.selectedHotels;
    // console.log(this.selectedHotel);
    const userDetails = JSON.parse(localStorage.getItem('key'));
    this.hotelService.bookingRoomDetails.userId = userDetails.userId;
    const userId = userDetails.userId;
    this.hotelService.getManagerHotel(userId);
  }

  bookRoom(room) {
    this.hotelService.userSelectedRoom(room);
  }

  RoomDetails(hotelId) {
    console.log(hotelId);
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
