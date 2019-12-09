import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-binding',
  templateUrl: './binding.component.html',
  styleUrls: ['./binding.component.css']
})
export class BindingComponent implements OnInit {
  inputData;
  flag = false;
  
  name='Udaykumar';
  imgURL = 'https://cdn.pixabay.com/photo/2019/10/06/11/58/sunshine-4530030__340.jpg';

  constructor() {
    setInterval(() =>{
      this.flag = !this.flag;
    }, 1000)

    // setTimeout(() => {
    //   this.flag = true;
    // }, 2000);
   }

   eventOccured(input){
     console.log(input.value);
     console.log('Key up event occured');
   }

  ngOnInit() {
  }

}
