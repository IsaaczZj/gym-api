package br.com.isaac.gym_api.database.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(name = "muscle_group", nullable = false)
    private String muscleGroup;


    @ManyToMany(mappedBy = "exercises")
    private Set<WorkoutsEntity> workouts = new HashSet<>();
}
