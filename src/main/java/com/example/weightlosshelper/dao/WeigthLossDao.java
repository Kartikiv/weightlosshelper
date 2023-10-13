package com.example.weightlosshelper.dao;

import com.example.weightlosshelper.entity.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface WeigthLossDao {
    public UserInformation save(UserInformation userInformation);
    public UserInformation getById(UserInformation userInformation);
    public WeightData saveWeight(WeightData weightData);
    public WeightData addWeigth(WeightData weightData);
    public  List<WeightData> findAllWeigthByUserInformationUserId(Long userId);
    public List<CalorieIntake> findAllCaloriesByUserInformationUserId(Long userId);
    public FoodHistory saveUserFoodIntake(FoodHistory foodHistory);
    public List<FoodHistory> getFoodHistory(Long userId);
    public Food getFoodById(Long foodId);
    public Food saveFood(Food food);
    public List<Food>getUserEatenFood (Long userId);
    public  List<FoodConsumptionHistory> getFoodEatenByUser(Long userId);
    public FoodConsumptionHistory saveFoodConsumption(FoodConsumptionHistory foodConsumptionHistory);




}
