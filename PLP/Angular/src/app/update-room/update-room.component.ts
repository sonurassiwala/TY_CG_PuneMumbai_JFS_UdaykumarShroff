import { Component, OnInit } from '@angular/core';
import { RoomService } from '../room.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-room',
  templateUrl: './update-room.component.html',
  styleUrls: ['./update-room.component.css']
})
export class UpdateRoomComponent implements OnInit {
  selectedRoom = null;
  message: string = null;
  constructor(public roomService: RoomService, private router: Router) {
    this.selectedRoom = this.roomService.selectedRoom;
  }

  updateForm(form: NgForm) {
    this.roomService.updateRoom(form.value).subscribe(response => {
      console.log(response);
      if (response.statusCode === 201) {
        this.message = response.description;
        form.reset();
        // this.roomService.getRoom(this.selectedRoom.roomId);
      } else if (response.statusCode === 401) {
        this.message = response.description;
      }
      this.roomService.showAllRooms();
      this.router.navigateByUrl('/room-list');
    }, err => {
      console.log(err);
    });
  }


  ngOnInit() {
  }

}
