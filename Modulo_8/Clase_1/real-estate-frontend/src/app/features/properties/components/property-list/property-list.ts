import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common'; // Necesario para pipes como currency
import { Property } from '../../models/property'; // Importa la interfaz Property
import { FormsModule } from '@angular/forms';

@Component({
  standalone: true,
  selector: 'app-property-list',
  imports: [CommonModule,FormsModule], // Importa CommonModule para usar pipes como currency
  templateUrl: './property-list.html', // Ruta actualizada
  styleUrl: './property-list.css' // Ruta actualizada
})
export class PropertyList implements OnInit {
  properties: Property[] = [];
  loading: boolean = true;
  error: string | null = null;
  allProperties: Property[] = []; // Para guardar todas las propiedades y poder filtrar
  filterCity: string = ''; 

  constructor() { }

  ngOnInit(): void {
    this.loading = true;
    this.error = null;

    // Simulación de carga de datos con un retraso
    setTimeout(() => {
      const simulatedData: Property[] = [
        {
          id: 1,
          address: '123 Calle del Sol',
          city: 'Madrid',
          price: 350000,
          bedrooms: 3,
          bathrooms: 2,
          imageUrl: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROM_tkr50bz0XK-3ZPQKiyW7gNj6HLuyhWrw&s',
          description: 'Amplia casa familiar con jardín y piscina, cerca de servicios.'
        },
        {
          id: 2,
          address: '456 Avenida de la Luna',
          city: 'Barcelona',
          price: 280000,
          bedrooms: 2,
          bathrooms: 1,
          imageUrl: 'https://i.pinimg.com/736x/e5/93/fc/e593fcbdb5eaa1726541eac131ccbb51.jpg',
          description: 'Apartamento luminoso en el centro de la ciudad, con vistas.'
        },
        {
          id: 3,
          address: '789 Plaza Mayor',
          city: 'Sevilla',
          price: 180000,
          bedrooms: 1,
          bathrooms: 1,
          imageUrl: 'https://placehold.co/400x300/C0C0C0/555555?text=Estudio+Acogedor',
          description: 'Estudio acogedor ideal para estudiantes o parejas, buena ubicación.'
        },
        {
          id: 4,
          address: '101 Calle del Río',
          city: 'Valencia',
          price: 450000,
          bedrooms: 4,
          bathrooms: 3,
          imageUrl: 'https://placehold.co/400x300/B0B0B0/666666?text=Chalet+Lujo',
          description: 'Chalet de lujo con amplios espacios y acabados de alta calidad.'
        },
        {
          id: 4,
          address: '101 Calle del Río',
          city: 'Valencia',
          price: 450000,
          bedrooms: 4,
          bathrooms: 3,
          imageUrl: 'https://placehold.co/400x300/B0B0B0/666666?text=Chalet+Lujo',
          description: 'Chalet de lujo con amplios espacios y acabados de alta calidad.'
        }
      ];
      this.allProperties = simulatedData; // Guarda todas las propiedades
      this.properties = this.allProperties; // Inicialmente muestra todas
      this.loading = false;
    }, 1500); // Simula un retraso de 1.5 segundos
  }

  // Nuevo método para filtrar propiedades
  filterProperties(): void {
    if (!this.filterCity) {
      this.properties = this.allProperties; // Si el filtro está vacío, muestra todas
    } else {
      this.properties = this.allProperties.filter(property =>
        property.city.toLowerCase().includes(this.filterCity.toLowerCase())
      );
    }
  }

}