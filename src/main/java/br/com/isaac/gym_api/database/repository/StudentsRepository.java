package br.com.isaac.gym_api.database.repository;

import br.com.isaac.gym_api.database.model.StudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentsRepository extends JpaRepository<StudentsEntity, UUID> {
}
