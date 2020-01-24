import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Room } from './room';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  api = 'http://localhost:8080/';

  constructor(private http: HttpClient) { }

  rooms: Room[] = [];
  selectedRoom: Room = null;

  showAllRooms() {
    this.http.get<any>(`${this.api}showAllRooms`).subscribe(data => {
      console.log(data);
      this.rooms = data.roomList;
      console.log(this.rooms);
    }, err => {
      console.log(err);
    });
  }

  showManagerRooms(hotelId) {
    this.http.get<any>(`${this.api}showManagerRooms?hotelId=${hotelId}`).subscribe(data => {
      console.log(data);
      this.rooms = data.roomList;
      console.log(this.rooms);
    }, err => {
      console.log(err);
    });
  }

  deleteRoom(room): Observable<any> {
    return this.http.delete(`${this.api}deleteRoom?roomId=${room.roomId}`);
  }
  updateRoom(room): Observable<any> {
    console.log(room.imgURL);
    return this.http.put(`${this.api}updateRoom?roomId=${room.roomId}`, room);
  }
  getRoom(room) {
    this.selectedRoom = room;
    return this.http.get(`${this.api}getRoom?roomId=${room.roomId}`);
  }
  addRoom(room) {
    return this.http.post<any>(`${this.api}addRoom`, room);
  }
}
