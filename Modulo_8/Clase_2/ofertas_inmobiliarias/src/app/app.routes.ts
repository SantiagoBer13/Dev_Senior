import { Routes } from '@angular/router';
import { ProjectDetail } from './features/properties/components/project-detail/project-detail';
import { PropertyListTradicional } from './features/properties/components/property-list-tradicional/property-list-tradicional';

export const routes: Routes = [
      {
    path: 'projects',
    component: PropertyListTradicional
  },
  {
    path: 'projects/:id',
    component: ProjectDetail
  },
  {
    path: '',
    redirectTo: 'projects',
    pathMatch: 'full',
  }
];
