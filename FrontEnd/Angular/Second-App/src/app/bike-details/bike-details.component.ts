import { Component, OnInit, Input } from '@angular/core';
import { Bike } from '../bike';

@Component({
  selector: 'app-bike-details',
  templateUrl: './bike-details.component.html',
  styleUrls: ['./bike-details.component.css']
})
export class BikeDetailsComponent implements OnInit {

  @Input() bike: Bike;

  constructor() { }

  ngOnInit() {
  }

}
