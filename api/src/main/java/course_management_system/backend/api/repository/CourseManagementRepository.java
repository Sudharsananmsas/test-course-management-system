package course_management_system.backend.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import course_management_system.backend.api.model.CourseManagement;

@Repository
public interface CourseManagementRepository extends JpaRepository <CourseManagement, Long> {


}
