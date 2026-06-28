package br.com.isaac.gym_api.service;

import br.com.isaac.gym_api.database.model.ExercisesEntity;
import br.com.isaac.gym_api.database.model.StudentsEntity;
import br.com.isaac.gym_api.database.model.WorkoutsEntity;
import br.com.isaac.gym_api.database.repository.ExercisesRepository;
import br.com.isaac.gym_api.database.repository.StudentsRepository;
import br.com.isaac.gym_api.database.repository.WorkoutsRepository;
import br.com.isaac.gym_api.dto.workouts.CreateWorkoutRequestDTO;
import br.com.isaac.gym_api.dto.workouts.WorkoutResponseDTO;
import br.com.isaac.gym_api.exception.AppErrorException;
import br.com.isaac.gym_api.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkoutsService {

    private final WorkoutsRepository workoutsRepository;
    private final StudentsRepository studentsRepository;
    private final ExercisesRepository exercisesRepository;


    public void create(CreateWorkoutRequestDTO newWorkout) throws NotFoundException {
        Set<ExercisesEntity> exercises = new HashSet<>();

        StudentsEntity student = studentsRepository.findById(newWorkout.student_id())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        if (workoutsRepository.findByNameIgnoreCaseAndStudentId(newWorkout.name(), newWorkout.student_id()).isPresent()) {
            throw new AppErrorException("Já existe um treino com esse nome para esse aluno", HttpStatus.BAD_REQUEST.value());
        }

        for (UUID id : newWorkout.exercise_ids()) {
            ExercisesEntity exercise = exercisesRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Exercício %s não encontrado", id)));

            exercises.add(exercise);
        }

        WorkoutsEntity workout = WorkoutsEntity.builder()
                .name(newWorkout.name())
                .exercises(exercises)
                .student(student)
                .build();
        workoutsRepository.save(workout);
    }


}
