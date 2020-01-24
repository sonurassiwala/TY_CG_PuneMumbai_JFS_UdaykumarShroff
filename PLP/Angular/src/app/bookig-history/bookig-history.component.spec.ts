import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookigHistoryComponent } from './bookig-history.component';

describe('BookigHistoryComponent', () => {
  let component: BookigHistoryComponent;
  let fixture: ComponentFixture<BookigHistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BookigHistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookigHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
