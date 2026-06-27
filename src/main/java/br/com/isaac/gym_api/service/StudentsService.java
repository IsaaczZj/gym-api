package br.com.isaac.gym_api.service;

import br.com.isaac.gym_api.database.model.StudentsEntity;
import br.com.isaac.gym_api.database.repository.PhysicalAssessmentRepository;
import br.com.isaac.gym_api.database.repository.StudentsRepository;
import br.com.isaac.gym_api.dto.physicalAssessment.PhysicalAssessmentResponseDTO;
import br.com.isaac.gym_api.dto.students.CreateStudentRequestDTO;
import br.com.isaac.gym_api.dto.students.StudentsResponseDTO;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentsService {

    private final StudentsRepository studentsRepository;

    private final PhysicalAssessmentRepository physicalAssessmentRepository;

    public void create(CreateStudentRequestDTO newStudent) {
        studentsRepository.save(
            StudentsEntity.builder()
                .email(newStudent.email())
                .name(newStudent.name())
                .build()
        );
    }

    public List<StudentsResponseDTO> findAll() {
        return studentsRepository
            .findAll()
            .stream()
            .map(StudentsResponseDTO::fromEntity)
            .toList();
    }

    public List<PhysicalAssessmentResponseDTO> findAllPhysicalAssessment(
        UUID id
    ) {
        return physicalAssessmentRepository
            .findAllByStudentId(id)
            .stream()
            .map(PhysicalAssessmentResponseDTO::fromEntity)
            .toList();
    }
}
