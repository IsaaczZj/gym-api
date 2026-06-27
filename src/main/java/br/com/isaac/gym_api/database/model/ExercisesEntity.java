package br.com.isaac.gym_api.database.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "exercises")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ExercisesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(name = "muscle_group", nullable = false)
    private String muscleGroup;


    @ManyToMany(mappedBy = "exercises")
    @Builder.Default
    private Set<WorkoutsEntity> workouts = new HashSet<>();
}
