import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit {

  childData = 'This data is from child';

  @Input() dataFromParent;

  @Output() childEvent = new EventEmitter();

  constructor() {}

  ngOnInit() {
    this.childEvent.emit(this.childData);
  }

}
