import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Project } from '../../models/proyect';
import { CommonModule, CurrencyPipe } from '@angular/common';

@Component({
  selector: 'app-property-card-tradicional',
  imports: [CommonModule],
  templateUrl: './property-card-tradicional.html',
  styleUrl: './property-card-tradicional.css',
})
export class PropertyCardTradicional {
  @Input() property!: Project; // Recibe una propiedad del componente padre

  // Emite un evento cuando se hace clic en "Ver Detalles"
  @Output() viewDetails = new EventEmitter<number>();

  constructor() { }

  onViewDetailsClick(): void {
    this.viewDetails.emit(this.property.id); 
    // Emite el ID de la propiedad
  }
}
