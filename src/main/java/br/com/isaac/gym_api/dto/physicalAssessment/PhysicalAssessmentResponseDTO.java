package br.com.isaac.gym_api.dto.physicalAssessment;

import br.com.isaac.gym_api.database.model.ExercisesEntity;
import br.com.isaac.gym_api.database.model.PhysicalAssessmentEntity;
import br.com.isaac.gym_api.dto.exercises.ExerciseReponseDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record PhysicalAssessmentResponseDTO(
    UUID id,
    BigDecimal weight,
    BigDecimal height,
    BigDecimal bodyFatPercentage,
    LocalDateTime createdAt,
    String studentName
) {
    public static PhysicalAssessmentResponseDTO fromEntity(
        PhysicalAssessmentEntity physicalAssessment
    ) {
        return new PhysicalAssessmentResponseDTO(
            physicalAssessment.getId(),
            physicalAssessment.getWeight(),
            physicalAssessment.getHeight(),
            physicalAssessment.getBodyFatPercentage(),
            physicalAssessment.getCreatedAt(),
            physicalAssessment.getStudent().getName()
        );
    }
}
