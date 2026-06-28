package br.com.isaac.gym_api.database.repository;

import br.com.isaac.gym_api.database.model.WorkoutsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkoutsRepository extends JpaRepository<WorkoutsEntity, UUID> {
    Optional<WorkoutsEntity> findByNameIgnoreCaseAndStudentId(String name, UUID id);
    List<WorkoutsEntity> findAllByStudentId(UUID id);
}
