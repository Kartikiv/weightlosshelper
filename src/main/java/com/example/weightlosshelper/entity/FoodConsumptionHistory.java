package com.example.weightlosshelper.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodConsumptionHistory  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long consumptionId;

    @CreationTimestamp
    private Date consumptionDate;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserInformation userInformation;

    @OneToMany
    private List<Food> food;



}
