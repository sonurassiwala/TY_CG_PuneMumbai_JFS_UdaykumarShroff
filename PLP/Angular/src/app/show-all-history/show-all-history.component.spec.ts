import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowAllHistoryComponent } from './show-all-history.component';

describe('ShowAllHistoryComponent', () => {
  let component: ShowAllHistoryComponent;
  let fixture: ComponentFixture<ShowAllHistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowAllHistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowAllHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
