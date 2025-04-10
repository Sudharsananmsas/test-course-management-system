import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CourseComponent } from "./course/course.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CourseComponent,],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'course-management';
}
