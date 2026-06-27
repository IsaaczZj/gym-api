package br.com.isaac.gym_api.dto.physicalAssessment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record CreatePhysicalAssessmentRequestDTO(

        @NotNull(message = "Informe o peso do aluno")
        BigDecimal weight,

        @NotNull(message = "Informe a altura do aluno")
        BigDecimal height,

        @NotNull(message = "Informe o percentual de gordura do aluno")
        BigDecimal bodyFatPercentage,

        @NotNull(message = "Informe o id do aluno")
        UUID student_id,

        @NotNull(message = "Informe a data de criação da avaliação do aluno")
        LocalDateTime createdAt

) {
}
