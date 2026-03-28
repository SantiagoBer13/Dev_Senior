import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router'; // Si estuviera el router
import { PropertyList } from './features/properties/components/property-list/property-list'; // Importa tu componente

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet, // Si estuviera el router
    PropertyList // Añade tu componente aquí
  ],
  templateUrl: './app.html', // Ruta actualizada
  styleUrl: './app.css' // Ruta actualizada
})
export class App {
  title = 'real-estate-frontend';
}