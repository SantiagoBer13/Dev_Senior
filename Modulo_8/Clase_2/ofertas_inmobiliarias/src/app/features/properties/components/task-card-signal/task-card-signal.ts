import { Component, input, output } from '@angular/core';
import { Task } from '../../models/task';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-task-card-signal',
  imports: [CommonModule],
  templateUrl: './task-card-signal.html',
  styleUrl: './task-card-signal.css',
})
export class TaskCardSignal {

  task = input.required<Task>();
  completed_task = output<number>()

  completedTask(): void {
    this.completed_task.emit(this.task().id); 
    // Emite el ID de la propiedad
  }

}
