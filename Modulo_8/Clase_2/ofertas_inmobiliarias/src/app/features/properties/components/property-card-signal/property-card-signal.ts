import { Component, computed, input, output } from '@angular/core';
import { Project } from '../../models/proyect';
import { CommonModule } from '@angular/common';
import { TaskCardSignal } from '../task-card-signal/task-card-signal';

@Component({
  selector: 'app-property-card-signal',
  imports: [CommonModule],
  templateUrl: './property-card-signal.html',
  styleUrl: './property-card-signal.css',
})
export class PropertyCardSignal {

  project= input.required<Project>();
  idProject = output<number>();
  viewDetails = output<number>();

  onViewDetailsClick(): void {
    this.viewDetails.emit(this.project().id); 
    // Emite el ID de la propiedad
  }

}
