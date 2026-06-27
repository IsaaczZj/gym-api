package br.com.isaac.gym_api.database.repository;

import br.com.isaac.gym_api.database.model.ExercisesEntity;
import br.com.isaac.gym_api.dto.exercises.ExerciseReponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExercisesRepository extends JpaRepository<ExercisesEntity, UUID> {

}
