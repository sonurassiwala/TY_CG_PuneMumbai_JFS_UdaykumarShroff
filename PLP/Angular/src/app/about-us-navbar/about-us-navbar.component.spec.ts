import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AboutUsNavbarComponent } from './about-us-navbar.component';

describe('AboutUsNavbarComponent', () => {
  let component: AboutUsNavbarComponent;
  let fixture: ComponentFixture<AboutUsNavbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AboutUsNavbarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AboutUsNavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
