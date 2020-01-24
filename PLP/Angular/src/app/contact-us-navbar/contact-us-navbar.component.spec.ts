import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ContactUsNavbarComponent } from './contact-us-navbar.component';

describe('ContactUsNavbarComponent', () => {
  let component: ContactUsNavbarComponent;
  let fixture: ComponentFixture<ContactUsNavbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ContactUsNavbarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ContactUsNavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
