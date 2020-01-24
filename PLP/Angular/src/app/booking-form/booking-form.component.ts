import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HotelService } from '../hotel.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-booking-form',
  templateUrl: './booking-form.component.html',
  styleUrls: ['./booking-form.component.css']
})
export class BookingFormComponent implements OnInit {

  dateObject = new Date();
  date = this.dateObject.getDate();
  month = this.dateObject.getMonth();
  year = this.dateObject.getFullYear();

  todaysDate = `${this.year}-${this.month + 1}-${this.date}`;

  constructor(private hotelService: HotelService) { }

  bookRoom(bookingForm: NgForm) {
    if ((bookingForm.value.checkinDate >= this.todaysDate) && (bookingForm.value.checkoutDate >= bookingForm.value.checkinDate)) {
      console.log(bookingForm.value);
      // sending data of booking form
      this.hotelService.userPaymentForm(bookingForm.value);
    } else {
      alert('Please Enter Valid Date from today onwards');
    }
  }

  ngOnInit() {
  }

}
