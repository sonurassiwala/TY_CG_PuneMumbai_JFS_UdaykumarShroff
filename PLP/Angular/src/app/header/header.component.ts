import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router: Router, private hotelService: HotelService) { }
  openLogin() {
    this.router.navigateByUrl('/login');
  }

  openRegister() {
    this.router.navigateByUrl('/register');
  }

  /* Set the width of the side navigation to 250px */
  openNav() {
    document.getElementById('mySidenav').style.width = '250px';
  }

  /* Set the width of the side navigation to 0 */
  closeNav() {
    document.getElementById('mySidenav').style.width = '0';
  }


  isUser(): boolean {
    const userDetails = JSON.parse(localStorage.getItem('key'));
    if (userDetails.userType === 'User') {
      return true;
    } else {
      return false;
    }
  }

  isManager(): boolean {
    const userDetails = JSON.parse(localStorage.getItem('key'));
    if (userDetails.userType === 'Manager') {
      return true;
    } else {
      return false;
    }
  }


  isAdmin(): boolean {
    const userDetails = JSON.parse(localStorage.getItem('key'));
    console.log(userDetails);
    if (userDetails.userType === 'Admin') {
      return true;
    } else {
      return false;
    }
  }


  ngOnInit() {
  }

}
