package br.com.isaac.gym_api.database.repository;

import br.com.isaac.gym_api.database.model.WorkoutsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkoutsRepository extends JpaRepository<WorkoutsEntity, UUID> {
}
