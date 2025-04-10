import { Component, Inject } from '@angular/core';
import { CourseService } from '../services/course.service';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { CommonModule } from '@angular/common';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule } from '@angular/forms';
import { DialogModule } from '@angular/cdk/dialog';

@Component({
  selector: 'app-course-edit',
  imports: [ CommonModule,
    MatFormFieldModule,
    MatInputModule,
    MatCardModule,
    MatButtonModule,
    FormsModule,
  DialogModule],
  templateUrl: './course-edit.component.html',
  styleUrl: './course-edit.component.scss'
})
export class CourseEditComponent {
  course: any;  

  constructor(
    public dialogRef: MatDialogRef<CourseEditComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any, 
    private courseService: CourseService
  ) {
    this.course = { ...data }; 
  }

  
  onSave(): void {
    this.courseService.updateCourse(this.course).subscribe((updatedCourse) => {
      this.dialogRef.close(updatedCourse); 
    });
  }

  
  onCancel(): void {
    this.dialogRef.close();
  }
}
