package br.com.isaac.gym_api.dto.exercises;


import br.com.isaac.gym_api.database.model.ExercisesEntity;

import java.util.UUID;

public record ExerciseReponseDTO(
        UUID id,
        String name,
        String muscleGroup
) {
    public static ExerciseReponseDTO fromEntity(ExercisesEntity exercise) {
        return new ExerciseReponseDTO(
                exercise.getId(),
                exercise.getName(),
                exercise.getMuscleGroup()
        );
    }
}
