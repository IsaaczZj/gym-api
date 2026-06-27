package br.com.isaac.gym_api.controller;

import br.com.isaac.gym_api.dto.exercises.CreateExerciseRequestDTO;
import br.com.isaac.gym_api.dto.exercises.ExerciseReponseDTO;
import br.com.isaac.gym_api.service.ExercisesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/exercises")
@RequiredArgsConstructor
public class ExercisesController {

    private final ExercisesService exercisesService;

    @GetMapping
    public ResponseEntity<List<ExerciseReponseDTO>> findAllExercises() {
        return ResponseEntity.ok(exercisesService.findAll());
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> create(@RequestBody CreateExerciseRequestDTO newExercise) {
        exercisesService.create(newExercise);
        return ResponseEntity.ok(Map.of("message", "Exercício criado com sucesso"));
    }
}
