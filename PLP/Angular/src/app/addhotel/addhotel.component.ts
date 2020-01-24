import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-addhotel',
  templateUrl: './addhotel.component.html',
  styleUrls: ['./addhotel.component.css']
})
export class AddhotelComponent implements OnInit {
  message: any;

  constructor(private router: Router, private hotel: HotelService) { }
  printForm(data: any) {

    this.hotel.addhotel(data.value).subscribe(response => {
      console.log(response);
      if (response.statusCode === 201) {
        this.message = response.description;
        alert(this.message);
      } else if (response.statusCode === 401) {
        this.message = response.description;
        alert(this.message);
      }
      data.reset();
      this.router.navigateByUrl('/hotel-list');
    }
    );
  }

  ngOnInit() {
  }

}
