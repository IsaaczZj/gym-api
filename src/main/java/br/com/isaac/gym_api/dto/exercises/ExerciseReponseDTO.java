package br.com.isaac.gym_api.dto.exercises;


import br.com.isaac.gym_api.database.model.ExercisesEntity;

public record ExerciseReponseDTO(
        String id,
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
