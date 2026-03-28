import { CommonModule } from '@angular/common';
import { Component, computed, signal } from '@angular/core';
import { Project } from '../../models/proyect';
import { ActivatedRoute, Router } from '@angular/router';
import { TaskCardSignal } from '../task-card-signal/task-card-signal';

@Component({
  selector: 'app-project-detail',
  imports: [CommonModule,TaskCardSignal],
  templateUrl: './project-detail.html',
  styleUrl: './project-detail.css',
})
export class ProjectDetail {
    projectId!: number;
  // project?: Project;

  simulatedData2 = signal<Project[]>([]);
  project = computed(() =>
    this.simulatedData2().find(p => p.id === this.projectId)
  );
  project_completed = computed(() =>
    this.project()?.tasks.every(t => t.state === 'completed') ?? false
  );
  constructor(private route: ActivatedRoute,private router: Router) {}

  ngOnInit(): void {
    this.projectId = Number(this.route.snapshot.paramMap.get('id'));
    console.log('ID:', this.projectId);
    // 🔹 Simulación (luego será API)
    this.loadProjects();
  }

  navProjects(): void {
    this.router.navigate(['/projects']);
  }


  loadProjects(): void{
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
  }

  sumCompletedTask(taskId: number): void {
    this.simulatedData2.update(projects =>
      projects.map(project => {
        if (project.id !== this.projectId) return project;

        return {
          ...project,
          tasks: project.tasks.map(task =>
            task.id === taskId
              ? { ...task, state: 'completed' }
              : task
          )
        };
      })
    );
  }

  
}
