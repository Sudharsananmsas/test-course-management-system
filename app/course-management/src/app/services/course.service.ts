import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  private apiUrl = 'http://localhost:8080/api/courses';

  constructor(private http: HttpClient) {}

  addCourse(course: any): Observable<any> {
    return this.http.post(this.apiUrl, course);
  }

  getCourses(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }
  updateCourse(course: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${course.id}`, course);
  }

  updateCourseState(id: number, active: boolean): Observable<any> {
    const endpoint = active ? `${this.apiUrl}/${id}/activate` : `${this.apiUrl}/${id}/deactivate`;
    return this.http.put(endpoint, {});
  }

  deleteCourse(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}
