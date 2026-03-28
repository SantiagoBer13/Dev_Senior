import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PropertyCardSignal } from './property-card-signal';

describe('PropertyCardSignal', () => {
  let component: PropertyCardSignal;
  let fixture: ComponentFixture<PropertyCardSignal>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PropertyCardSignal]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PropertyCardSignal);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
