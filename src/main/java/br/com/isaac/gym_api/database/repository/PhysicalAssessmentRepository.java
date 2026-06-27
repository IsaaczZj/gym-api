package br.com.isaac.gym_api.database.repository;

import br.com.isaac.gym_api.database.model.PhysicalAssessmentEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhysicalAssessmentRepository
    extends JpaRepository<PhysicalAssessmentEntity, UUID>
{
    Optional<PhysicalAssessmentEntity> findFirstByStudentIdOrderByCreatedAtDesc(
        UUID studentId
    );

    List<PhysicalAssessmentEntity> findAllByStudentId(UUID id);
}
