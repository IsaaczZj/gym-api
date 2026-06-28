package br.com.isaac.gym_api.controller;

import br.com.isaac.gym_api.dto.physicalAssessment.CreatePhysicalAssessmentRequestDTO;
import br.com.isaac.gym_api.dto.physicalAssessment.PhysicalAssessmentResponseDTO;
import br.com.isaac.gym_api.exception.NotFoundException;
import br.com.isaac.gym_api.service.PhysicalAssessmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/physical-assessment")
@RequiredArgsConstructor
@Validated
public class PhysicalAssessmentController {

    private final PhysicalAssessmentService physicalAssessmentService;

    @PostMapping
    public ResponseEntity<Map<String, String>> createAssessment(@Valid @RequestBody CreatePhysicalAssessmentRequestDTO newPhysicalAssessment) throws NotFoundException {
        physicalAssessmentService.create(newPhysicalAssessment);
        return ResponseEntity.ok(Map.of("message", "Avaliação física criada com sucesso"));
    }

    @GetMapping
    public ResponseEntity<List<PhysicalAssessmentResponseDTO>> findAll(){
        return ResponseEntity.ok(physicalAssessmentService.findAll());
    }

}
