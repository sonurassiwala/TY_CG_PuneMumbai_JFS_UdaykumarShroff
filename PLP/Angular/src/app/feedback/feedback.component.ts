import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {

  constructor(private router: Router) { }

  feedback(feedbackForm: NgForm) {
    this.router.navigateByUrl('/');
  }


  ngOnInit() {
  }

}
