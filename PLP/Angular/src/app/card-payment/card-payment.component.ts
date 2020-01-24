import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HotelService } from '../hotel.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-card-payment',
  templateUrl: './card-payment.component.html',
  styleUrls: ['./card-payment.component.css']
})
export class CardPaymentComponent implements OnInit {

  constructor(private hotelService: HotelService, private router: Router) { }
  // cardPayment1() {
  //   this.hotelService.paymentCardMode().subscribe(response => {
  //     console.log(response);

  //     this.router.navigateByUrl('/booking-confirm');
  //   }, err => {
  //     console.log(err);
  //   });
  // }
  cardPayment(paymentForm: NgForm) {
    this.hotelService.paymentCardMode().subscribe(response => {
      console.log(response);
      this.router.navigateByUrl('/booking-confirm');
    }, err => {
      console.log(err);
    });
  }



  back() {
    this.router.navigateByUrl('/mode-of-payment');
  }


  ngOnInit() {
  }

}
