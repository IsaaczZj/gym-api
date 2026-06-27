package br.com.isaac.gym_api.database.repository;

import br.com.isaac.gym_api.database.model.StudentsEntity;
import br.com.isaac.gym_api.dto.workouts.PhysicalAssessmentResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StudentsRepository extends JpaRepository<StudentsEntity, UUID> {

}
