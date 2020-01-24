import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerHotelComponent } from './manager-hotel.component';

describe('ManagerHotelComponent', () => {
  let component: ManagerHotelComponent;
  let fixture: ComponentFixture<ManagerHotelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerHotelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerHotelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
