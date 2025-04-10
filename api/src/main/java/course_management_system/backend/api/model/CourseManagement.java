package course_management_system.backend.api.model;

import java.time.Instant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "course_management")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String udemyLink;
    private boolean active;

    @CreationTimestamp
    private Instant createdAt;
    
    @CreationTimestamp
    private Instant modifiedAt;

}
