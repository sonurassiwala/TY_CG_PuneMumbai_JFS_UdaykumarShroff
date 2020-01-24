import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Hotel } from './hotel';
import { User } from './user';
import { BookData } from './bookData';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  api = 'http://localhost:8080/';
  profile = [];
  hotels: Hotel[] = [];
  users: User[] = [];


  bookedData: BookData[] = [];
  selectedHotels = [];
  visitorHotelData = [];
  managerHotel = [];

  totalAmount = null;

  bookingRoomDetails = {
    userId: null,
    hotelId: null,
    roomId: null,
    amount: null,
    checkinDate: null,
    checkoutDate: null,
    paymentStatus: null,
    modeOfPayment: null
  };


  constructor(private http: HttpClient, private router: Router) {
  }

  isLoggedIn(): boolean {
    const userDetails = JSON.parse(localStorage.getItem('key'));
    if (userDetails) {
      return true;
    } else {
      return false;
    }
  }

  userLogin(data: any) {
    return this.http.post<any>(`${this.api}userLogin?email=${data.email}&password=${data.password}`, data);
  }

  userRegister(data: any) {
    return this.http.post<any>(`${this.api}registerUser`, data);
  }

  getProfileData(userId) {
    this.http.get<any>(`${this.api}showProfile?userId=${userId}`).subscribe(data => {
      this.profile = data.userBean;
    }, err => {
      console.log(err);
    });
  }

  forgotPassword(data: any) {
    // tslint:disable-next-line: max-line-length
    return this.http.post<any>(`${this.api}updatePassword?email=${data.email}&phoneNumber=${data.phoneNumber}&password=${data.password}`, data);
  }

  updateProfileData(data) {
    console.log(data);
    return this.http.post<any>(`${this.api}updateProfile`, data);
  }

  addhotel(data: any) {
    return this.http.post<any>(`${this.api}addHotel`, data);
  }

  deleteHotel(data: any): Observable<any> {
    return this.http.delete<any>(`${this.api}deleteHotel?hotelId=${data}`, data);
  }


  updateHotelDetails(data: any) {
    return this.http.post<any>(`${this.api}updateHotelDetails`, data);
  }

  searchHotel(data: any) {
    return this.http.post<any>(`${this.api}searchHotel`, data);
  }

  getHotelDetails(data): Observable<any> {
    return this.http.get<any>(`${this.api}getHotelDetails?hotelId=${data.hotelId}`, data);
  }

  getShowAllHotel() {
    return this.http.get<any>(`${this.api}showAllHotels`).subscribe(data => {
      console.log(data.hotelList);
      this.hotels = data.hotelList;
    });
  }

  getHotelRoomDetails(hotelId): Observable<any> {
    return this.http.get<any>(`${this.api}showRooms?hotelId=${hotelId}`);
  }

  getAllUsers() {
    return this.http.get<any>(`${this.api}showAllUsers`).subscribe(data => {
      console.log(data.userList);
      this.users = data.userList;

    });
  }

  getAllManagers() {
    return this.http.get<any>(`${this.api}showAllManagers`).subscribe(data => {
      console.log(data.userList);
      this.users = data.userList;

    });
  }

  deleteUser(user): Observable<any> {
    return this.http.delete<any>(`${this.api}deleteUser?userId=${user}`, user);
  }


  getBill() {
    console.log(this.bookingRoomDetails);
    this.http.post<any>(`${this.api}getAmount`, this.bookingRoomDetails).subscribe(response => {
      console.log(response);
      console.log(this.bookingRoomDetails);
      this.totalAmount = response.totalAmount;
      console.log(this.totalAmount);
      this.router.navigateByUrl('/mode-of-payment');
    }, err => {
      console.log(err);
    });
  }

  userPaymentForm(bookingForm) {
    console.log(bookingForm.checkinDate);
    console.log(bookingForm.checkoutDate);
    // set check in date
    this.bookingRoomDetails.checkinDate = bookingForm.checkinDate;
    // set check out date
    this.bookingRoomDetails.checkoutDate = bookingForm.checkoutDate;
    this.getBill();
  }

  userSelectedHotel(hotel) {
    this.selectedHotels = hotel;
    this.bookingRoomDetails.hotelId = hotel.hotelId;
    this.router.navigateByUrl('/hotel-details');
  }

  userSelectedRoom(room) {
    this.bookingRoomDetails.roomId = room.roomId;
    this.router.navigateByUrl('/booking-form');
  }



  ShowAllHotel() {
    return this.http.get<any>(`${this.api}showAllHotels`).subscribe(data => {
      console.log(data.hotelList);
      this.hotels = data.hotelList;

    });
  }

  paymentCardMode(): Observable<any> {
    this.bookingRoomDetails.modeOfPayment = 'Card';
    this.bookingRoomDetails.paymentStatus = 'Paid';
    console.log(this.bookingRoomDetails);
    return this.http.post<any>(`${this.api}bookingRoom`, this.bookingRoomDetails);
  }


  paymentCashMode(): Observable<any> {
    this.bookingRoomDetails.modeOfPayment = 'Cash';
    this.bookingRoomDetails.paymentStatus = 'UnPaid';
    console.log(this.bookingRoomDetails);
    return this.http.post<any>(`${this.api}bookingRoom`, this.bookingRoomDetails);
  }


  getBookedDetails(user) {
    console.log(user);
    this.http.get<any>(`${this.api}getBookedRecords?userId=${user}`).subscribe(data => {
      this.bookedData = data.bookingInfoList;
      console.log(this.bookedData);
    }, err => {
      console.log(err);
    });
  }

  getHistoryBookedDetails() {
    this.http.get<any>(`${this.api}showAllHistory`).subscribe(data => {
      this.bookedData = data.historyList;
    }, err => {
      console.log(err);
    });
  }

  deleteBookedData(bookingDetails): Observable<any> {
    return this.http.delete(`${this.api}cancelBooking?bookingId=${bookingDetails.bookingId}`);
  }


  getVisitorHotelData(hotel) {
    console.log(hotel);
    return this.http.get<any>(`${this.api}getHotelDetails?hotelId=${hotel.hotelId}`).subscribe(data => {
      this.visitorHotelData = data.hotelBean;
      this.router.navigateByUrl('/visitor-hotel-details');
  },  err => {
    console.log(err);
    });
  }

  getManagerHotel(userId) {
    return this.http.get<any>(`${this.api}seeManagerHotel?userId=${userId}`).subscribe(data => {
      console.log(data.hotelBean);
      this.managerHotel = data.hotelBean;
      console.log(this.managerHotel);
    });
  }





}
