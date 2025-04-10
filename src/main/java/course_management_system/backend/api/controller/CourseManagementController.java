package course_management_system.backend.api.controller;

import course_management_system.backend.api.model.CourseManagement;
import course_management_system.backend.api.service.CourseManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseManagementController {

    @Autowired
    private CourseManagementService courseManagementService;

    @PostMapping
    public ResponseEntity<CourseManagement> addCourse(@RequestBody CourseManagement course) {
        return new ResponseEntity<>(courseManagementService.addCourse(course), HttpStatus.CREATED);
    }

    @GetMapping
    public List<CourseManagement> getAllCourses() {
        return courseManagementService.getAllCourses();
    }

    @GetMapping("/{id}")
    public CourseManagement getCourse(@PathVariable Long id) {
        return courseManagementService.getCourseById(id);
    }

    @PutMapping("/{id}/activate")
    public ResponseEntity<CourseManagement> activateCourse(@PathVariable Long id) {
        CourseManagement updatedCourse = courseManagementService.updateCourseState(id, true);
        return ResponseEntity.ok(updatedCourse);
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<CourseManagement> deactivateCourse(@PathVariable Long id) {
        CourseManagement updatedCourse = courseManagementService.updateCourseState(id, false);
        return ResponseEntity.ok(updatedCourse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseManagementService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
