package com.example.weightlosshelper.controller;

import com.example.weightlosshelper.dao.WeigthLossDao;
import com.example.weightlosshelper.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class WeigthLossController {
    final
    WeigthLossDao weigthLossDao;

    public WeigthLossController(WeigthLossDao weigthLossDao) {
        this.weigthLossDao = weigthLossDao;
    }

    @GetMapping("/hi")
    public String msg() {
        return "hi";
    }

    @PostMapping("/saveuser")
    public UserInformation save(@RequestBody UserInformation userInformation) {
        return weigthLossDao.save(userInformation);
    }

    @GetMapping("/getuserbyid")
    public UserInformation getById(@RequestBody UserInformation userInformation) {
        System.out.println("hi");
        return weigthLossDao.getById(userInformation);
    }

    @PostMapping("/saveweightdata")
    public WeightData save(@RequestBody WeightData weightData) {
        return weigthLossDao.saveWeight(weightData);
    }

    @GetMapping("/getuserweightdata")
    public List<WeightData> getUserWeightByUserId(@RequestParam("userid") Long userId) {
        return weigthLossDao.findAllWeigthByUserInformationUserId(userId);

    }

    @GetMapping("/getcaloriedata")
    public List<CalorieIntake> getUserCalorieIntake(@RequestParam("userid") Long userId) {
        return weigthLossDao.findAllCaloriesByUserInformationUserId(userId);
    }

    @PostMapping("/addweightdata")
    public WeightData addWeigthData(@RequestBody WeightData weigthData) {
        if (weigthData.getUserInformation() == null) {
            return new WeightData();
        }
        return weigthLossDao.addWeigth(weigthData);


    }

    @PostMapping("/addfoodhistory")
    public FoodHistory saveFoodHistory(@RequestBody FoodHistory foodHistory) {
        UserInformation user=getById(foodHistory.getUser());
        foodHistory.setUser(user);
        Food food= weigthLossDao.getFoodById(foodHistory.getFood().getFoodId());
        foodHistory.setFood(food);
        return weigthLossDao.saveUserFoodIntake(foodHistory);
    }

    @GetMapping("/getuserfoodhistory")
    public List<FoodHistory> getUserFoodHistory(@RequestParam Long userId) {
        return weigthLossDao.getFoodHistory(userId);

    }
    @GetMapping("/foodeatenbyuser")
    public List<Food>getUserEatenFood (@RequestParam Long userId){
        return weigthLossDao.getUserEatenFood(userId);
    }


    @GetMapping("/getfoodconsumption")
    public List<FoodConsumptionHistory> getFoodConSumptionHistory(@RequestParam Long userId){
        return weigthLossDao.getFoodEatenByUser(userId);
    }
    @PostMapping("/savefoodconsumption")
    public FoodConsumptionHistory saveFoodConsumptionHistory(@RequestBody FoodConsumptionHistory foodConsumptionHistory){
        return weigthLossDao.saveFoodConsumption(foodConsumptionHistory);
    }

    @PostMapping("/savefood")
    public  Food saveFood(Food food){
        return weigthLossDao.saveFood(food);
    }
}


