import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { User } from '../user';

@Component({
  selector: 'app-show-all-users',
  templateUrl: './show-all-users.component.html',
  styleUrls: ['./show-all-users.component.css']
})
export class ShowAllUsersComponent implements OnInit {
  message: string;

  constructor(private hotelService: HotelService) {
    this.hotelService.getAllUsers();
  }

  deleteUser(user: User) {
    this.hotelService.deleteUser(user).subscribe(response => {
      if (response.statusCode === 201) {
        console.log('user deleted');
        this.message = response.description;
        alert(this.message);
      } else if (response.statusCode === 401) {
        console.log('user not deleted');
        this.message = response.description;
        alert(this.message);
      }
      console.log(response);
      this.hotelService.getAllUsers();
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
