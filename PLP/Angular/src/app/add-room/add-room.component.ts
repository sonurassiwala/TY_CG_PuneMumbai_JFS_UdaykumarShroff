import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { RoomService } from '../room.service';

@Component({
  selector: 'app-add-room',
  templateUrl: './add-room.component.html',
  styleUrls: ['./add-room.component.css']
})
export class AddRoomComponent implements OnInit {

  constructor(private roomService: RoomService) { }
  message: string = null;
  submitForm(addRoom: NgForm) {
    const userDetails = JSON.parse(localStorage.getItem('key'));
    const getHotelId = userDetails.hotelId;
    console.log(getHotelId);
    this.roomService.addRoom({...addRoom.value, hotelId: getHotelId}).subscribe(response => {
      console.log(response);
      if (response.statusCode === 201) {
        this.message = response.description;
        addRoom.reset();
      } else if (response.statusCode === 401) {
        this.message = response.description;
      }
    }, err => {
      console.log(err);
    });

  }

  ngOnInit() {
  }

}
