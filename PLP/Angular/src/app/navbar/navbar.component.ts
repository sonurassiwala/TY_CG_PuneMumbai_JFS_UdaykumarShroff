import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private hotelService: HotelService, private router: Router) {
    this.hotelService.getShowAllHotel();
  }

  isLoggedIn(): boolean {
    const userDetails = JSON.parse(localStorage.getItem('key'));
    if (userDetails) {
      return true;
    } else {
      return false;
    }
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
    // console.log(userDetails);
    if (userDetails.userType === 'Admin') {
      return true;
    } else {
      return false;
    }
  }

  showProfile() {
    this.router.navigateByUrl('/profile');
  }

  logout() {
    localStorage.removeItem('key');
    this.router.navigateByUrl('/');
  }

  /* Set the width of the side navigation to 250px */
  openNav() {
    document.getElementById('mySidenav').style.width = '250px';
  }

  /* Set the width of the side navigation to 0 */
  closeNav() {
    document.getElementById('mySidenav').style.width = '0';
  }




  ngOnInit() {
  }

}
