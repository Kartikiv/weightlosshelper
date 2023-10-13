package com.example.weightlosshelper.dao;

import com.example.weightlosshelper.entity.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class WeightLossDaoImpl implements WeigthLossDao {
    final UserInformationRepository userInformationRepository;
    final WeightDataRepository weightDataRepository;
    final CaloriesIntakeRepository caloriesIntakeRepository;
    final
    FoodHistoryRepository foodHistoryRepository;
    final
    FoodRepository foodRepository;
    final FoodConsumptionHistoryRepository foodConsumptionHistoryRepository;

    public WeightLossDaoImpl(UserInformationRepository userInformationRepository, WeightDataRepository weightDataRepository, CaloriesIntakeRepository caloriesIntakeRepository, FoodHistoryRepository foodHistoryRepository, FoodRepository foodRepository, FoodConsumptionHistoryRepository foodConsumptionHistoryRepository) {
        this.userInformationRepository = userInformationRepository;
        this.weightDataRepository = weightDataRepository;
        this.caloriesIntakeRepository = caloriesIntakeRepository;
        this.foodHistoryRepository = foodHistoryRepository;
        this.foodRepository = foodRepository;
        this.foodConsumptionHistoryRepository = foodConsumptionHistoryRepository;
    }


    public UserInformation save(UserInformation userInformation) {
        return userInformationRepository.save(userInformation);
    }

    public UserInformation getById(UserInformation userInformation) {
        Optional<UserInformation> optionalUser = userInformationRepository.findById(userInformation.getUserId());
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return null;

    }

    public WeightData saveWeight(WeightData weightData) {
        return weightDataRepository.save(weightData);

    }



    public WeightData addWeigth(WeightData weightData) {

        return weightDataRepository.save(weightData);
    }

    public List<WeightData> findAllWeigthByUserInformationUserId(Long userId) {
        return weightDataRepository.findAllByUserInformationUserId(userId);
    }

    public List<CalorieIntake> findAllCaloriesByUserInformationUserId(Long userId) {
        return caloriesIntakeRepository.findAllByUserInformationUserId(userId);
    }

    public FoodHistory saveUserFoodIntake(FoodHistory foodHistory) {
        return foodHistoryRepository.save(foodHistory);
    }

    public List<FoodHistory> getFoodHistory(Long userId) {
        return foodHistoryRepository.findAllByUser_UserId(userId);

    }
    public Food getFoodById(Long foodId){
        return foodRepository.findById(foodId).get();

    }

    public Food saveFood(Food food){
        return foodRepository.save(food);
    }
    public List<Food>getUserEatenFood (Long userId){
        return foodHistoryRepository.findByUser_Id(userId);
    }

public  List<FoodConsumptionHistory> getFoodEatenByUser(Long userId){
        return foodConsumptionHistoryRepository.findAllByUserInformation_UserId(userId);
}

public FoodConsumptionHistory saveFoodConsumption(FoodConsumptionHistory foodConsumptionHistory){
        List <Food> finalFoodList=new ArrayList<>();
        UserInformation userInformation=userInformationRepository.findById(foodConsumptionHistory.getUserInformation().getUserId()).get();
        for(Food foodObj:foodConsumptionHistory.getFood()){
            Food food = foodRepository.findById(foodObj.getFoodId()).get();
            finalFoodList.add(food);
        }
        foodConsumptionHistory.setFood(finalFoodList);
        foodConsumptionHistory.setUserInformation(userInformation);
        return foodConsumptionHistoryRepository.save(foodConsumptionHistory);

}

}
