package br.com.isaac.gym_api.database.repository;

import br.com.isaac.gym_api.database.model.StudentsEntity;
import br.com.isaac.gym_api.dto.physicalAssessment.PhysicalAssessmentResponseDTO;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository
    extends JpaRepository<StudentsEntity, UUID> {}
