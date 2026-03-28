import { Component, OnInit, signal } from '@angular/core';
import { PropertyCardTradicional } from '../property-card-tradicional/property-card-tradicional';
import { CommonModule } from '@angular/common';
import { Project } from '../../models/proyect';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { PropertyCardSignal } from "../property-card-signal/property-card-signal";

@Component({
  selector: 'app-property-list-tradicional',
  standalone: true,
  imports: [CommonModule, FormsModule, PropertyCardSignal],
  templateUrl: './property-list-tradicional.html',
  styleUrl: './property-list-tradicional.css',
})
export class PropertyListTradicional implements OnInit {
  allProperties: Project[] = [];
  filterName: string = '';
  loading: boolean = true;
  error: string | null = null;
  properties: Project[] = [];
  simulatedData: Project[] = [];
  simulatedData2 = signal<Project[]>([]);

  constructor(private router: Router) { }

  ngOnInit() {
    this.loading = true;
    this.error = null;

    // Simulate an API call

    this.simulatedData = [
      {
        id: 1,
        name: 'Plataforma de Gestión de Mascotas',
        description: 'Sistema web para el control de historial médico, vacunas y seguimiento de mascotas.',
        imageUrl: 'https://i.blogs.es/111b32/captura-de-pantalla-2024-04-09-a-las-18.31.36/650_1200.jpeg',
        date_start: new Date('2025-01-10'),
        date_estimated: new Date('2025-03-30'),
        date_finish: new Date('2025-03-25'),
        manager: 'Santiago Bernal',
        tasks: [
          {
            id: 1,
            name: 'Diseño de interfaz UI/UX',
            date_start: new Date('2025-01-10'),
            date_finish: new Date('2025-01-20'),
            date_complete: new Date(''),
            responsible: 'Laura Gómez',
            state: "not_completed"
          },
          {
            id: 2,
            name: 'Desarrollo Frontend (Angular)',
            date_start: new Date('2025-01-21'),
            date_finish: new Date('2025-02-20'),
            date_complete: new Date(''),
            responsible: 'Carlos Pérez',
            state: "not_completed"
          },
          {
            id: 3,
            name: 'Integración Backend (NestJS)',
            date_start: new Date('2025-02-21'),
            date_finish: new Date('2025-03-20'),
            date_complete: new Date(''),
            responsible: 'Andrés Torres',
            state: "not_completed"
          }
        ]
      },
      {
        id: 2,
        name: 'Dashboard de Analítica',
        description: 'Dashboard interactivo para visualización de métricas y KPIs en tiempo real.',
        imageUrl: 'https://images.unsplash.com/photo-1551288049-bebda4e38f71',
        date_start: new Date('2025-02-01'),
        date_estimated: new Date('2025-04-15'),
        date_finish: new Date('2025-04-10'),
        manager: 'María Rodríguez',
        tasks: [
          {
            id: 1,
            name: 'Modelado de datos',
            date_start: new Date('2025-02-01'),
            date_finish: new Date('2025-02-10'),
            date_complete: new Date(''),
            responsible: 'Juan Medina',
            state: "not_completed"
          },
          {
            id: 2,
            name: 'Implementación de gráficos',
            date_start: new Date('2025-02-11'),
            date_finish: new Date('2025-03-10'),
            date_complete: new Date(''),
            responsible: 'Diana López',
            state: "not_completed"
          },
          {
            id: 3,
            name: 'Optimización y pruebas',
            date_start: new Date('2025-03-11'),
            date_finish: new Date('2025-04-10'),
            date_complete: new Date(''),
            responsible: 'Felipe Castro',
            state: "not_completed"
          }
        ]
      }
    ];

    this.simulatedData2.set([
      {
        id: 1,
        name: 'Plataforma de Gestión de Mascotas',
        description: 'Sistema web para el control de historial médico, vacunas y seguimiento de mascotas.',
        imageUrl: 'https://i.blogs.es/111b32/captura-de-pantalla-2024-04-09-a-las-18.31.36/650_1200.jpeg',
        date_start: new Date('2025-01-10'),
        date_estimated: new Date('2025-03-30'),
        date_finish: new Date('2025-03-25'),
        manager: 'Santiago Bernal',
        tasks: [
          {
            id: 1,
            name: 'Diseño de interfaz UI/UX',
            date_start: new Date('2025-01-10'),
            date_finish: new Date('2025-01-20'),
            date_complete: new Date(''),
            responsible: 'Laura Gómez',
            state: "not_completed"
          },
          {
            id: 2,
            name: 'Desarrollo Frontend (Angular)',
            date_start: new Date('2025-01-21'),
            date_finish: new Date('2025-02-20'),
            date_complete: new Date(''),
            responsible: 'Carlos Pérez',
            state: "not_completed"
          },
          {
            id: 3,
            name: 'Integración Backend (NestJS)',
            date_start: new Date('2025-02-21'),
            date_finish: new Date('2025-03-20'),
            date_complete: new Date(''),
            responsible: 'Andrés Torres',
            state: "not_completed"
          }
        ]
      },
      {
        id: 2,
        name: 'Dashboard de Analítica',
        description: 'Dashboard interactivo para visualización de métricas y KPIs en tiempo real.',
        imageUrl: 'https://images.unsplash.com/photo-1551288049-bebda4e38f71',
        date_start: new Date('2025-02-01'),
        date_estimated: new Date('2025-04-15'),
        date_finish: new Date('2025-04-10'),
        manager: 'María Rodríguez',
        tasks: [
          {
            id: 1,
            name: 'Modelado de datos',
            date_start: new Date('2025-02-01'),
            date_finish: new Date('2025-02-10'),
            date_complete: new Date(''),
            responsible: 'Juan Medina',
            state: "not_completed"
          },
          {
            id: 2,
            name: 'Implementación de gráficos',
            date_start: new Date('2025-02-11'),
            date_finish: new Date('2025-03-10'),
            date_complete: new Date(''),
            responsible: 'Diana López',
            state: "not_completed"
          },
          {
            id: 3,
            name: 'Optimización y pruebas',
            date_start: new Date('2025-03-11'),
            date_finish: new Date('2025-04-10'),
            date_complete: new Date(''),
            responsible: 'Felipe Castro',
            state: "not_completed"
          }
        ]
      }
    ]);
    this.allProperties = this.simulatedData; // Guarda todas las propiedades
    this.properties = this.allProperties; // Inicialmente muestra todas
    this.loading = false;

  }

  searchProperties(): void {
    if (!this.filterName) {
      this.properties = this.allProperties; // Si el filtro está vacío, muestra todas
    } else {
      this.properties = this.allProperties.filter(property =>
        property.name.toLowerCase().includes(this.filterName.toLowerCase())
      );
    }
  }

  handleViewDetails(propertyId: number): void {
    this.router.navigate(['/projects', propertyId]);
  }

  changeName(propertyId: number): void {
    const property = this.simulatedData.find(p => p.id === propertyId);

    if (property) {
      property.name = "Name changed";
    }
  }

}
