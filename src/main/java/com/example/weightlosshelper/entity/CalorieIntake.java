package com.example.weightlosshelper.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class CalorieIntake {
    @Id
    private Long calorieId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)

    private UserInformation userInformation;
    private Long calories;
    @CreationTimestamp
    private Date consumptionDate;

}
