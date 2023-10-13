package com.example.weightlosshelper.dao;

import com.example.weightlosshelper.entity.FoodConsumptionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodConsumptionHistoryRepository extends JpaRepository<FoodConsumptionHistory,Long> {

    public List<FoodConsumptionHistory> findAllByUserInformation_UserId(Long userId);



}
