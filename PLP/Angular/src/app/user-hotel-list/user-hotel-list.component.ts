import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { Hotel } from '../hotel';

@Component({
  selector: 'app-user-hotel-list',
  templateUrl: './user-hotel-list.component.html',
  styleUrls: ['./user-hotel-list.component.css']
})
export class UserHotelListComponent implements OnInit {

  constructor(private hotelService: HotelService) {
    this.hotelService.ShowAllHotel();
  }

  hotelList = this.hotelService.hotels;

  // selectedHotel = this.hotelList[0];

  selectHotel(hotel: Hotel) {
    console.log(hotel);
    this.hotelService.userSelectedHotel(hotel);
    // this.selectedHotel = hotel;
  }

  ngOnInit() {
  }

}
