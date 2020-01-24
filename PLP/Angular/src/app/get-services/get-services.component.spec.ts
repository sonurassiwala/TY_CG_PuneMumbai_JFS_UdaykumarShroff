import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetServicesComponent } from './get-services.component';

describe('GetServicesComponent', () => {
  let component: GetServicesComponent;
  let fixture: ComponentFixture<GetServicesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetServicesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetServicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
