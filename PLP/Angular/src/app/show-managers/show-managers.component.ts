import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { User } from '../user';

@Component({
  selector: 'app-show-managers',
  templateUrl: './show-managers.component.html',
  styleUrls: ['./show-managers.component.css']
})
export class ShowManagersComponent implements OnInit {
  message: any;

  constructor(private hotelService: HotelService) {
    this.hotelService.getAllManagers();
  }

  deleteManager(user: User) {
    this.hotelService.deleteUser(user).subscribe(response => {
      if (response.statusCode === 201) {
        this.message = response.description;
        alert(this.message);
      } else if (response.statusCode === 401) {
        this.message = response.description;
        alert(this.message);
      }
      console.log(response);
      this.hotelService.getAllManagers();
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
