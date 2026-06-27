package br.com.isaac.gym_api.dto.exercises;

public record CreateExerciseRequestDTO(
        String name,
        String muscleGroup
) {

}
