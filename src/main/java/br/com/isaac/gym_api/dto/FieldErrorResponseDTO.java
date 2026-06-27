package br.com.isaac.gym_api.dto;

public record FieldErrorResponseDTO(
        String field,
        String message
) {
}
