package br.com.isaac.gym_api.service;

import br.com.isaac.gym_api.database.model.ExercisesEntity;
import br.com.isaac.gym_api.database.repository.ExercisesRepository;
import br.com.isaac.gym_api.dto.exercises.CreateExerciseRequestDTO;
import br.com.isaac.gym_api.dto.exercises.ExerciseReponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExercisesService {
    private final ExercisesRepository exercisesRepository;

    public List<ExerciseReponseDTO> findAll(String muscleGroup) {
        if (muscleGroup != null && !muscleGroup.isBlank()) {
            return exercisesRepository.findAllByMuscleGroupIgnoreCase(muscleGroup)
                    .stream()
                    .map(ExerciseReponseDTO::fromEntity)
                    .toList();
        }

        return exercisesRepository.findAll().stream().map(ExerciseReponseDTO::fromEntity).toList();
    }

    public void create(CreateExerciseRequestDTO newExercise) {
        exercisesRepository.save(ExercisesEntity.builder()
                .name(newExercise.name())
                .muscleGroup(newExercise.muscleGroup())
                .build());
    }


}
