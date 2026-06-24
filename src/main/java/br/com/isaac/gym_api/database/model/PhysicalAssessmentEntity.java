package br.com.isaac.gym_api.database.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

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

}
