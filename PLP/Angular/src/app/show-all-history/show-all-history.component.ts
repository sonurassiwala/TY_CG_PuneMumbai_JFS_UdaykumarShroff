import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-show-all-history',
  templateUrl: './show-all-history.component.html',
  styleUrls: ['./show-all-history.component.css']
})
export class ShowAllHistoryComponent implements OnInit {

  constructor(private hotelService: HotelService) {
    this.hotelService.getHistoryBookedDetails();
  }

  ngOnInit() {
  }

}
