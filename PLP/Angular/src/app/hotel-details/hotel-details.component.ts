import { Component, OnInit, Input } from '@angular/core';
import { HotelService } from '../hotel.service';
import { Hotel } from '../hotel';

@Component({
  selector: 'app-hotel-details',
  templateUrl: './hotel-details.component.html',
  styleUrls: ['./hotel-details.component.css']
})
export class HotelDetailsComponent implements OnInit {

  roomDetails = [];
  hotelDetails = [];
  selectedHotel = [];

  constructor(private hotelService: HotelService) {
    this.selectedHotel = this.hotelService.selectedHotels;
  }

  bookRoom(room) {
    this.hotelService.userSelectedRoom(room);
  }

  selectedRoomDetails(hotelId) {
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
