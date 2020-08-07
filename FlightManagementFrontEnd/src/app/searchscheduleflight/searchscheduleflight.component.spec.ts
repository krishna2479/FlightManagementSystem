import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchscheduleFlightComponent } from './searchscheduleflight.component';

describe('SearchscheduleFlightComponent', () => {
  let component: SearchscheduleFlightComponent;
  let fixture: ComponentFixture<SearchscheduleFlightComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchscheduleFlightComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchscheduleFlightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
