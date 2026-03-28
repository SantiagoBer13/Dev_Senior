import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PropertyCardTradicional } from './property-card-tradicional';

describe('PropertyCardTradicional', () => {
  let component: PropertyCardTradicional;
  let fixture: ComponentFixture<PropertyCardTradicional>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PropertyCardTradicional]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PropertyCardTradicional);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
