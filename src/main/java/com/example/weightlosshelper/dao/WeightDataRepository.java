package com.example.weightlosshelper.dao;

import com.example.weightlosshelper.entity.WeightData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface WeightDataRepository extends JpaRepository<WeightData,Long> {
public  List<WeightData> findAllByUserInformationUserId(Long userId);
}
