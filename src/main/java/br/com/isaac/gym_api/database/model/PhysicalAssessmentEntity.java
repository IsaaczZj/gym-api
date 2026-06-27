package br.com.isaac.gym_api.database.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "physical_assessments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PhysicalAssessmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private BigDecimal weight;

    @Column(nullable = false)
    private BigDecimal height;

    @Column(name = "body_fat_percentage", nullable = false)
    private BigDecimal bodyFatPercentage;

    @Column(name = "created_at")
    LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private StudentsEntity student;
}
