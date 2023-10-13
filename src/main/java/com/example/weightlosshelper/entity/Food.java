package com.example.weightlosshelper.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;

    private String name;
    private double protein;
    private double carbohydrates;
    private double fats;
    private double calories; // Calories per serving 100g


    // Vitamins
    private double vitaminA;
    private double vitaminB1; // Thiamine
    private double vitaminB2; // Riboflavin
    private double vitaminB3; // Niacin
    private double vitaminB5; // Pantothenic Acid
    private double vitaminB6; // Pyridoxine
    private double vitaminB7; // Biotin
    private double vitaminB9; // Folate (Folic Acid)
    private double vitaminB12; // Cobalamin
    private double vitaminC;
    private double vitaminD;
    private double vitaminE;
    private double vitaminK;

    // Minerals
    private double calcium;
    private double iron;
    private double magnesium;
    private double potassium;
    private double zinc;
    private double phosphorus;
    private double sodium;
    private double selenium;
    private double copper;
    private double manganese;

    // Constructors, getters, and setters (similar to previous examples)

    // Additional getters and setters for vitamins, minerals, and calories (if needed)

    // toString() method (similar to previous examples)
}

