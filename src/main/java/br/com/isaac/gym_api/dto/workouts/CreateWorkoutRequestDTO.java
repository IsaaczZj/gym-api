package br.com.isaac.gym_api.dto.workouts;

import java.util.List;
import java.util.UUID;

public record CreateWorkoutRequestDTO(
        UUID student_id,
        String name,
        List<UUID> exercise_ids
) {
}
