package br.com.isaac.gym_api.controller;

import br.com.isaac.gym_api.dto.physicalAssessment.PhysicalAssessmentResponseDTO;
import br.com.isaac.gym_api.dto.students.CreateStudentRequestDTO;
import br.com.isaac.gym_api.dto.students.StudentsResponseDTO;
import br.com.isaac.gym_api.exception.NotFoundException;
import br.com.isaac.gym_api.service.StudentsService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@Validated
public class StudentsController {

    private final StudentsService studentsService;

    @PostMapping
    public ResponseEntity<Map<String, String>> create(
        @Valid @RequestBody CreateStudentRequestDTO newStudent
    ) {
        studentsService.create(newStudent);
        return ResponseEntity.ok(Map.of("message", "Aluno criado com sucesso"));
    }

    @GetMapping
    public ResponseEntity<List<StudentsResponseDTO>> findAll() {
        return ResponseEntity.ok(studentsService.findAll());
    }

    @GetMapping("/physical-assessment/{id}")
    public ResponseEntity<
        List<PhysicalAssessmentResponseDTO>
    > findAllPhysicalAssessment(@PathVariable UUID id) throws NotFoundException {
        return ResponseEntity.ok(studentsService.findAllPhysicalAssessment(id));
    }
}
