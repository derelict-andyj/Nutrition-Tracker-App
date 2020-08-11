package com.example.Nutrition.Tracker.App.controller;

import java.util.List;

import com.example.Nutrition.Tracker.App.data.dao.FoodEntryDao;
import com.example.Nutrition.Tracker.App.data.models.FoodEntry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/foods")
public class FoodEntryController {
  
  @Autowired
  private FoodEntryDao foodEntryDao;
 

  @GetMapping(value = "/{id}", produces = "application/json")
  public FoodEntry getFoodEntry(@PathVariable final Long id) {
    FoodEntry founFoodEntry = foodEntryDao.getById(id);
    if(founFoodEntry != null) {
      return founFoodEntry;
      }else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Food not found.");
    }
  }

  @GetMapping(produces = "application/json")
  public List<FoodEntry> getFoods(){
    return foodEntryDao.findAllFoods();
  }
}