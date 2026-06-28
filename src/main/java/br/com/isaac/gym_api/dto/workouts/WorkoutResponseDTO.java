package br.com.isaac.gym_api.dto.workouts;

import br.com.isaac.gym_api.database.model.WorkoutsEntity;
import br.com.isaac.gym_api.dto.exercises.ExerciseReponseDTO;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public record WorkoutResponseDTO(
        UUID id,
        String name,
        Set<ExerciseReponseDTO> exercises
) {
    public static WorkoutResponseDTO fromEntity(WorkoutsEntity workouts) {
        return new WorkoutResponseDTO(
                workouts.getId(),
                workouts.getName(),
                workouts.getExercises()
                        .stream()
                        .map(ExerciseReponseDTO::fromEntity)
                        .collect(Collectors.toSet())
        );
    }
}
