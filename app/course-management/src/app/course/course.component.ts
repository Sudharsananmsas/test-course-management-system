import { Component, OnInit } from '@angular/core';
import { CourseService } from '../services/course.service';
import { CommonModule } from '@angular/common';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-course',
  imports: [
    CommonModule,
    MatFormFieldModule,
    MatInputModule,
    MatCardModule,
    MatButtonModule,
    FormsModule,
  ],
  templateUrl: './course.component.html',
  styleUrl: './course.component.scss',
})
export class CourseComponent implements OnInit {
  courses: any[] = [];
  newCourse = {
    title: '',
    description: '',
    udemyLink: '',
    active: true,
  };

  constructor(private courseService: CourseService) {}

  ngOnInit(): void {
    this.getCourses();
  }

  getCourses(): void {
    this.courseService.getCourses().subscribe((data) => {
      this.courses = data;
    });
  }

  onAddCourse(): void {
    this.courseService.addCourse(this.newCourse).subscribe((added) => {
      this.courses.push(added);
      this.newCourse = {
        title: '',
        description: '',
        udemyLink: '',
        active: true,
      };
    });
  }

  CourseState(course: any): void {
    const newState = !course.active;
    this.courseService.updateCourseState(course.id, newState).subscribe(() => {
      course.active = newState;
    });
  }

  deleteCourse(course: any): void {
    this.courseService.deleteCourse(course.id).subscribe(() => {
      this.courses = this.courses.filter((c) => c.id !== course.id);
    });
  }
}
