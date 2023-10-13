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

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class WeightData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long weightId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)

    private UserInformation userInformation;
    private BigDecimal weight;
    @CreationTimestamp
    private Date createdDate;


}
