package com.example.weightlosshelper.dao;

import com.example.weightlosshelper.entity.Food;
import com.example.weightlosshelper.entity.FoodHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FoodHistoryRepository extends JpaRepository<FoodHistory, Long> {

    public List<FoodHistory> findAllByUser_UserId(Long userId);
    @Modifying
    @Query("select  f  from Food  f left join FoodHistory fh on f.foodId=fh.food.foodId where fh.user.userId=:userId")
    public List<Food>findByUser_Id(@Param("userId")  Long userId);

}
