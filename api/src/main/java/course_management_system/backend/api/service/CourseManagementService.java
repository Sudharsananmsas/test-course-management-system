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

    public void deleteCourse(Long id) {
        courseManagementRepository.deleteById(id);
    }
}
