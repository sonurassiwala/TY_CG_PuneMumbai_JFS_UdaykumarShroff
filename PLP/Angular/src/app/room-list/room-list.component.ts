import { Component, OnInit } from '@angular/core';
import { Room } from '../room';
import { RoomService } from '../room.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.css']
})
export class RoomListComponent implements OnInit {

  selectedRoom: Room = {
    roomId: null,
    roomRent: null,
    roomType: null,
    roomCapacity: null,
    roomStatus: null,
    hotelId: null,
    imgURL: null
  };
  message: string = null;

  constructor(private roomService: RoomService, private router: Router) {
    const userDetails = JSON.parse(localStorage.getItem('key'));
    this.roomService.showManagerRooms(userDetails.hotelId);
    console.log(userDetails.hotelId);
  }
  deleteRoom(room: Room) {
    this.roomService.deleteRoom(room).subscribe(response => {
      if (response.statusCode === 201) {
        this.message = response.description;
      } else if (response.statusCode === 401) {
        this.message = response.description;
      }
      console.log(response);
      const userDetails = JSON.parse(localStorage.getItem('key'));
      this.roomService.showManagerRooms(userDetails.hotelId);
    }, err => {
      console.log(err);
    });
  }
  selectRoom(room: Room) {
    this.selectedRoom = room;
    this.roomService.selectedRoom = room;
    console.log(this.roomService.selectedRoom);
    this.router.navigateByUrl('/update-room');
  }

  ngOnInit() {
  }

}
