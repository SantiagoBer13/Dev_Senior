import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TaskCardSignal } from './task-card-signal';

describe('TaskCardSignal', () => {
  let component: TaskCardSignal;
  let fixture: ComponentFixture<TaskCardSignal>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TaskCardSignal]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TaskCardSignal);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
