import { Component, OnInit } from '@angular/core';
import { Student } from '../student';

@Component({
  selector: 'app-structural-directives',
  templateUrl: './structural-directives.component.html',
  styleUrls: ['./structural-directives.component.css']
})
export class StructuralDirectivesComponent implements OnInit {

  flag = false;
  person= 'suraj';

  students: Student[] = [
    {
      id: 123,
      name: 'Amit',
      age: 21,
      degree: 'B.E.'
    },
    {
      id: 124,
      name: 'Suraj',
      age: 23,
      degree: 'B.Tech.'
    },
    {
      id: 125,
      name: 'Rushikesh',
      age: 21,
      degree: 'B.E.'
    },
    {
      id: 126,
      name: 'Niranjan',
      age: 20,
      degree: 'Bsc'
    }
  ];

  constructor() {
    setTimeout(() => {
      this.flag = true;
    }, 2000);
   }

   deleteStudent(student: Student){
     let index = this.students.indexOf(student);
     this.students.splice(index, 1);
   }

  ngOnInit() {
  }

}
