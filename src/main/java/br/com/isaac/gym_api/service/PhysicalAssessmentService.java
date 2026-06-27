package br.com.isaac.gym_api.service;

import br.com.isaac.gym_api.database.model.PhysicalAssessmentEntity;
import br.com.isaac.gym_api.database.model.StudentsEntity;
import br.com.isaac.gym_api.database.repository.PhysicalAssessmentRepository;
import br.com.isaac.gym_api.database.repository.StudentsRepository;
import br.com.isaac.gym_api.dto.physicalAssessment.CreatePhysicalAssessmentRequestDTO;
import br.com.isaac.gym_api.exception.AppErrorException;
import br.com.isaac.gym_api.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PhysicalAssessmentService {
    private final StudentsRepository studentsRepository;
    private final PhysicalAssessmentRepository physicalAssessmentRepository;

    public void create(CreatePhysicalAssessmentRequestDTO newPhysicalAssessment) throws NotFoundException {
        StudentsEntity student = studentsRepository.
                findById(newPhysicalAssessment.student_id())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        PhysicalAssessmentEntity lastAssessment = physicalAssessmentRepository.findByStudentIdOrderByCreatedAtDesc(student.getId()).orElse(null);

        if (lastAssessment != null) {
            LocalDateTime minimumDate = LocalDateTime.now().minusMonths(2);

            boolean assessmentWasCreatedLessTwoMonthsAgo = lastAssessment.getCreatedAt().isAfter(minimumDate);

            if (assessmentWasCreatedLessTwoMonthsAgo) {
                LocalDateTime nextAllowedDate = lastAssessment.getCreatedAt().plusMonths(2);

                throw new AppErrorException(
                        "A próxima avaliação física só pode ser criada em " + nextAllowedDate,
                        HttpStatus.BAD_REQUEST.value()
                );
            }

            physicalAssessmentRepository.save(PhysicalAssessmentEntity.builder()
                    .createdAt(newPhysicalAssessment.createdAt())
                    .height(newPhysicalAssessment.height())
                    .weight(newPhysicalAssessment.weight())
                    .build());
        }

    }
}
