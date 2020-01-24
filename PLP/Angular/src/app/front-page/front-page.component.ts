import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-front-page',
  templateUrl: './front-page.component.html',
  styleUrls: ['./front-page.component.css']
})
export class FrontPageComponent implements OnInit {
  name: any;

  constructor() {
    const userDetails = JSON.parse(localStorage.getItem('key'));
    this.name = userDetails.userName;
  }

  ngOnInit() {
  }

}
