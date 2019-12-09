import { Component, OnInit } from '@angular/core';
import { Bike } from '../bike';

@Component({
  selector: 'app-bikes',
  templateUrl: './bikes.component.html',
  styleUrls: ['./bikes.component.css']
})
export class BikesComponent implements OnInit {

  bikes: Bike[] = [
    {
      brand: 'Royal Enfieid',
      imgURL: 'https://cdn.pixabay.com/photo/2018/07/01/11/42/royal-enfield-3509231__340.jpg',
      model: 'Classic 350',
      price: 175000,
      specs: `Royal Enfield Classic 350 price starts at Rs.1.46 lakh (Ex-Showroom, Delhi) and the top end variant
       Royal Enfield Classic 350 Signals Edition is priced at Rs. 1.64 lakh (Ex-Showroom, Delhi). 
       The 346cc, single cylinder, 4-stroke, twin-spark motor generates a maximum output of 20.08PS at 5250rpm and
        28Nm of torque at 4000rpm. The power is transferred to the rear wheel via a five-speed gearbox.
         The Classic has a fuel capacity of 13.5 litres and weighs in at 192kg. Braking is managed by a 280mm disc 
         up front and a 230mm drum at the rear. Royal Enfield Classic 350 Competitors Mojo 300: The Mahindra Mojo does 
         great justice to its touring dynamics. The refined motor, comfortable riding dynamics, supple ride quality and
          loaded parts bin make it a great motorcycle for long distance riding .`
    },
    {
      brand: 'Yamaha',
      imgURL: 'https://cdn.pixabay.com/photo/2019/03/24/22/03/traffic-4078819__340.jpg',
      model: 'R15',
      price: 95000,
      specs: `The king of Indian streets at one time, the legendary Yamaha RX100 can amaze the riders and the onlookers in the same way as KTM 200 Duke. The 98cc motorcycle was good for 11 BHP and 10.39 Nm of torque while weighs just 103 kg. It claimed a top speed of 100 kmph while was quite unsafe because of just drum brakes at both ends. It was discontinued due to change in emission norms, as RX 100 was a 2-stroke motorcycle. As of now, Yamaha has no plans to re-launch the RX 100 in India.`
    },
    {
      brand: 'Honda',
      imgURL: 'https://cdn.pixabay.com/photo/2017/10/12/19/19/motorcycle-2845525__340.jpg',
      model: 'CBR',
      price: 185000,
      specs: `The king of Indian streets at one time, the legendary Yamaha RX100 can amaze the riders and the onlookers in the same way as KTM 200 Duke. The 98cc motorcycle was good for 11 BHP and 10.39 Nm of torque while weighs just 103 kg. It claimed a top speed of 100 kmph while was quite unsafe because of just drum brakes at both ends. It was discontinued due to change in emission norms, as RX 100 was a 2-stroke motorcycle. As of now, Yamaha has no plans to re-launch the RX 100 in India.`
    }
  ];

  selectedBike: Bike = this.bikes[0];

  constructor() { }

  selectBike(bike){
    this.selectedBike = bike;
  }

  ngOnInit() {
  }

}
