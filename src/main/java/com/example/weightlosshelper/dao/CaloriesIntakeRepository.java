package com.example.weightlosshelper.dao;

import com.example.weightlosshelper.entity.CalorieIntake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaloriesIntakeRepository extends JpaRepository<CalorieIntake,Long> {
    public List<CalorieIntake> findAllByUserInformationUserId(Long userId);
}
