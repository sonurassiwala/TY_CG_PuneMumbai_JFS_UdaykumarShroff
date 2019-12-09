import { Component, OnInit } from '@angular/core';
import { Product } from '../product';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  products: Product[] = [
    {
      name: 'SmartPhone',
      imgURL: 'https://cdn.pixabay.com/photo/2015/03/26/09/41/phone-690091__340.jpg',
      price: 35499,
      brand: 'Spice'
    },
    {
      name: 'Laptop',
      imgURL: 'https://cdn.pixabay.com/photo/2018/03/01/09/33/laptop-3190194__340.jpg',
      price: 68799,
      brand: 'MSI'
    },
    {
      name: 'Cat',
      imgURL: 'https://cdn.pixabay.com/photo/2015/03/27/13/16/cat-694730__340.jpg',
      price: 50000,
      brand: 'Indian'
    },
    {
      name: 'Dog',
      imgURL: 'https://cdn.pixabay.com/photo/2018/05/07/10/48/husky-3380548__340.jpg',
      price: 30000,
      brand: 'Husky'
    },
    {
      name: 'Speaker',
      imgURL: 'https://cdn.pixabay.com/photo/2017/03/29/08/09/the-speaker-grill-2184439__340.jpg',
      price: 15000,
      brand: 'Ahuja'
    },
    {
      name: 'Headphone',
      imgURL: 'https://cdn.pixabay.com/photo/2016/11/29/09/08/headphone-1868612__340.jpg',
      price: 5000,
      brand: 'boatRockerz'
    },
    {
      name: 'T.V.',
      imgURL: 'https://image.shutterstock.com/image-photo/4k-monitor-isolated-on-white-260nw-357968483.jpg',
      price: 85000,
      brand: 'LG'
    },
    {
      name: 'Camera',
      imgURL: 'https://cdn.pixabay.com/photo/2014/12/27/15/31/camera-581126__340.jpg',
      price: 35000,
      brand: 'Canon'
    }
  ];

  constructor() { }

  ngOnInit() {
  }

}
