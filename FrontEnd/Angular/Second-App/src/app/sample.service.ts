import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class SampleService{
    laptop = 'HP';

    printService(){
        console.log('Function is Running from Service');
    }
}