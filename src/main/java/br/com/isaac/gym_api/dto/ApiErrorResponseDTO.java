package br.com.isaac.gym_api.dto;

import java.time.LocalDateTime;
import java.util.List;

public record ApiErrorResponseDTO(int status,
                                  String message,
                                  String path,
                                  LocalDateTime timestamp,
                                  List<FieldErrorResponseDTO> errors) {
}
