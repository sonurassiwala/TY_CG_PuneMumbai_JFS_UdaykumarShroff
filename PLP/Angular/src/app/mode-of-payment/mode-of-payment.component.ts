import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-mode-of-payment',
  templateUrl: './mode-of-payment.component.html',
  styleUrls: ['./mode-of-payment.component.css']
})
export class ModeOfPaymentComponent implements OnInit {

  totalAmount = null;
  selectedRoomDetails = null;

  constructor(private hotelService: HotelService, private router: Router) {
    // setting booking info data
    this.selectedRoomDetails = this.hotelService.bookingRoomDetails;
  }

  selectMethod() {
    this.router.navigateByUrl('/card-payment');
  }

  cashPayment() {
    this.hotelService.paymentCashMode().subscribe(response => {
      console.log(response);
      this.router.navigateByUrl('/booking-confirm');
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
