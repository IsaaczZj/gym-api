package br.com.isaac.gym_api.dto.students;

import br.com.isaac.gym_api.database.model.StudentsEntity;

import java.util.UUID;

public record StudentsResponseDTO(
        UUID id,
        String name,
        String email

) {

    public static StudentsResponseDTO fromEntity(StudentsEntity student) {
        return new StudentsResponseDTO(
                student.getId(),
                student.getName(),
                student.getEmail()
        );
    }
}
