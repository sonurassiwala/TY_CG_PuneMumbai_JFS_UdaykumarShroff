import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VisitorHotelDetailsComponent } from './visitor-hotel-details.component';

describe('VisitorHotelDetailsComponent', () => {
  let component: VisitorHotelDetailsComponent;
  let fixture: ComponentFixture<VisitorHotelDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VisitorHotelDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VisitorHotelDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
