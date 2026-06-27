package br.com.isaac.gym_api.database.repository;

import br.com.isaac.gym_api.database.model.PhysicalAssessmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PhysicalAssessmentRepository extends JpaRepository<PhysicalAssessmentEntity, UUID> {
    Optional<PhysicalAssessmentEntity> findByStudentIdOrderByCreatedAtDesc(UUID student_id);
}
