import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CourseList } from './features/courses/components/course-list/course-list';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CourseList],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  title = 'university-courses-frontend';
}
