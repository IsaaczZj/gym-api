package br.com.isaac.gym_api.dto.students;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateStudentRequestDTO(
        @NotBlank(message = "O nome do aluno é obrigatório")
        @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
        String name,

        @NotBlank(message = "O e-mail do aluno é obrigatório")
        @Email(message = "Informe um e-mail válido")
        String email
) {
}
