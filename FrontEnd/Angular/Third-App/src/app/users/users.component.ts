import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users: [];

  constructor(http: HttpClient) {
    http.get<any>('../../assets/users.json').subscribe(data => {
      console.log(data);
      this.users = data;
    },
    err=>{
      console.log(err);
     
    }
    );
   }

  ngOnInit() {
  }

}
