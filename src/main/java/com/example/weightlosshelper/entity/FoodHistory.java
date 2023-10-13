package com.example.weightlosshelper.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FoodHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDate dateConsumed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInformation user;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    // Constructors, getters, and setters
}

