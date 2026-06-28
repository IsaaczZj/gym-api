package br.com.isaac.gym_api.controller;

import br.com.isaac.gym_api.dto.workouts.CreateWorkoutRequestDTO;
import br.com.isaac.gym_api.exception.NotFoundException;
import br.com.isaac.gym_api.service.WorkoutsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/workout")
@RequiredArgsConstructor
@Validated
public class WorkoutsController {

    private final WorkoutsService workoutsService;

    @PostMapping
    public ResponseEntity<Map<String, String>> create(@Valid @RequestBody CreateWorkoutRequestDTO newWorkout) throws NotFoundException {
        workoutsService.create(newWorkout);

        return ResponseEntity.ok(Map.of("message", "Treino criado com sucesso"));
    }
}
