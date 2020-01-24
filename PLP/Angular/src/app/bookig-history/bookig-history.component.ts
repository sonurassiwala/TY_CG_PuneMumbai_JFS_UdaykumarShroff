import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-bookig-history',
  templateUrl: './bookig-history.component.html',
  styleUrls: ['./bookig-history.component.css']
})
export class BookigHistoryComponent implements OnInit {
  message: any;

  constructor(private hotelService: HotelService) {
    const userDetails = JSON.parse(localStorage.getItem('key'));
    const user = userDetails.userId;
    this.hotelService.getBookedDetails(user);
   }

   deleteHistory(bookingDetails) {
    console.log(bookingDetails);
    this.hotelService.deleteBookedData(bookingDetails).subscribe(response => {
      console.log(response);
      if (response.statusCode === 201) {
        this.message = response.description;
        alert(this.message);
      } else if (response.statusCode === 401) {
        this.message = response.description;
        alert(this.message);
      }
      const userDetails = JSON.parse(localStorage.getItem('key'));
      console.log(userDetails.userId);
      const user = userDetails.userId;
      this.hotelService.getBookedDetails(user);
      // this.hotelService.getTotalBill(user);
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
