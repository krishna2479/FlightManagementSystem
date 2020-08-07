import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddscheduleflightComponent } from './addscheduleflight.component';

describe('AddscheduleflightComponent', () => {
  let component: AddscheduleflightComponent;
  let fixture: ComponentFixture<AddscheduleflightComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddscheduleflightComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddscheduleflightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
