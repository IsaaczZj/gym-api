package br.com.isaac.gym_api.dto.exercises;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateExerciseRequestDTO(

        @NotBlank(message = "O nome do exercício é obrigatório")
        @Size(min = 2, max = 100, message = "O nome deve ter entre mínimo 2 caracteres")
        String name,

        @NotBlank(message = "O grupo muscular é obrigatório")
        @Size(min = 2, max = 50, message = "O grupo muscular deve ter no mínimo 2 caracteres")
        String muscleGroup
) {

}
