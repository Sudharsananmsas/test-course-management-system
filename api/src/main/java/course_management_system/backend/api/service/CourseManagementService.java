package course_management_system.backend.api.service;

import course_management_system.backend.api.model.CourseManagement;
import course_management_system.backend.api.repository.CourseManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseManagementService {
    @Autowired
    private CourseManagementRepository courseManagementRepository;

    public CourseManagement addCourse(CourseManagement course) {
        return courseManagementRepository.save(course);
    }
    public List<CourseManagement> getAllCourses() {
        return courseManagementRepository.findAll();
    }

    public CourseManagement getCourseById(Long id) {
        return courseManagementRepository.findById(id).orElse(null);
        
    }

    public CourseManagement updateCourseState(Long id, boolean active) {
        CourseManagement course = getCourseById(id);
        course.setActive(active);
        return courseManagementRepository.save(course);
    }
    public CourseManagement updateCourse(Long id, CourseManagement course) {
        if (courseManagementRepository.existsById(id)) {
            CourseManagement existingCourse = courseManagementRepository.findById(id).get();
            existingCourse.setTitle(course.getTitle());
            existingCourse.setDescription(course.getDescription());
            existingCourse.setUdemyLink(course.getUdemyLink());
            existingCourse.setActive(course.isActive());
            return courseManagementRepository.save(existingCourse); 
        } else {
            throw null;
        }
    }

    public void deleteCourse(Long id) {
        courseManagementRepository.deleteById(id);
    }
}
