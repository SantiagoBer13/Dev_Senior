import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Course } from '../../models/course.model'; // Asegúrate de que la ruta sea correcta

@Component({
  selector: 'app-course-list',
  imports: [CommonModule, FormsModule],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList implements OnInit {
  courses: Course[] = [];
  allCourses: Course[] = [];
  filterTerm: string = '';
  loading: boolean = true; // Para simular carga

  constructor() { }

  ngOnInit(): void {
    this.loading = true;
    // Simular carga de datos
    setTimeout(() => {
      this.allCourses = [
        {
          id: 1,
          code: 'CS101',
          name: 'Introducción a la Programación',
          credits: 3,
          professor: 'Dr. Ana Pérez',
          description: 'Fundamentos de programación utilizando Python.',
          imageUrl: 'https://placehold.co/400x200/E0E0E0/333333?text=CS101'
        },
        {
          id: 2,
          code: 'MA203',
          name: 'Cálculo Multivariable',
          credits: 4,
          professor: 'Prof. Juan García',
          description: 'Estudio de funciones de varias variables, derivadas parciales e integrales múltiples.',
          imageUrl: 'https://placehold.co/400x200/D0D0D0/444444?text=MA203'
        },
        {
          id: 3,
          code: 'HI301',
          name: 'Historia Universal',
          credits: 3,
          professor: 'Dra. Laura Gómez',
          description: 'Recorrido por los eventos y civilizaciones más importantes de la historia.',
          imageUrl: 'https://placehold.co/400x200/C0C0C0/555555?text=HI301'
        },
        {
          id: 4,
          code: 'PH101',
          name: 'Filosofía Antigua',
          credits: 3,
          professor: 'Prof. Carlos Ruiz',
          description: 'Exploración de las principales corrientes filosóficas de la antigüedad.',
          imageUrl: 'https://placehold.co/400x200/B0B0B0/666666?text=PH101'
        },
        {
          id: 5,
          code: 'CS205',
          name: 'Estructuras de Datos',
          credits: 4,
          professor: 'Dr. Ana Pérez',
          description: 'Implementación y análisis de estructuras de datos fundamentales.',
          imageUrl: 'https://placehold.co/400x200/A0A0A0/777777?text=CS205'
        }
      ];
      this.courses = this.allCourses; // Inicialmente, mostrar todos los cursos
      this.loading = false;
    }, 1000);
  }

  filterCourses(): void {
    if (!this.filterTerm) {
      this.courses = this.allCourses;
    } else {
      this.courses = this.allCourses.filter(course =>
        course.name.toLowerCase().includes(this.filterTerm.toLowerCase()) ||
        course.code.toLowerCase().includes(this.filterTerm.toLowerCase())
      );
    }
  }
}