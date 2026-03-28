import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PropertyListTradicional } from './property-list-tradicional';

describe('PropertyListTradicional', () => {
  let component: PropertyListTradicional;
  let fixture: ComponentFixture<PropertyListTradicional>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PropertyListTradicional]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PropertyListTradicional);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
