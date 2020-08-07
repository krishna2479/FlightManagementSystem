import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowflightComponent } from './showflight.component';

describe('ShowflightComponent', () => {
  let component: ShowflightComponent;
  let fixture: ComponentFixture<ShowflightComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowflightComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowflightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
