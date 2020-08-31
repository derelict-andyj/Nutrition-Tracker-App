package com.derelictmansion.nutrition.controller;

import java.util.Optional;
import javax.validation.Valid;
import com.derelictmansion.nutrition.data.dao.FoodEntryDao;
import com.derelictmansion.nutrition.data.models.FoodEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(value = "/foods")
public class FoodEntryController {
  
  @Autowired
  private FoodEntryDao foodEntryDao;
 

  @GetMapping(value = "/{id}", produces = "application/json")
  public FoodEntry getFoodEntry(@PathVariable final Long id) {
    Optional<FoodEntry> founFoodEntry = foodEntryDao.findById(id);
    if(founFoodEntry.isPresent()) {
      return founFoodEntry.get();
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Food not found.");
    }
  }

  @GetMapping(produces = "application/json")
  public Iterable<FoodEntry> getFoods(){
    return foodEntryDao.findAll();
  }

  //Add food entries
  @PostMapping(consumes = "application/json", produces = "application/json")
  public void addFoodEntry(@Valid @RequestBody final FoodEntry foodEntry) {
    foodEntryDao.save(foodEntry);
  }

  //Update food entries
  @PutMapping(value="/{id}", consumes = "application/json", produces = "application/json") 
  public FoodEntry updateFoodEntry(@PathVariable final Long id, @Valid @RequestBody final FoodEntry foodEntry) {

    Optional<FoodEntry> optionalFoodEntry = foodEntryDao.findById(id);
    return optionalFoodEntry.map(updateFoodEntry -> {
      updateFoodEntry.setCalories(foodEntry.getCalories());
      updateFoodEntry.setCarbs(foodEntry.getCarbs());
      updateFoodEntry.setDescription(foodEntry.getDescription());
      updateFoodEntry.setFat(foodEntry.getFat());
      updateFoodEntry.setProtien(foodEntry.getProtien());
      updateFoodEntry.setName(foodEntry.getName());
      return foodEntryDao.save(updateFoodEntry);
    }).orElseThrow(() ->
      new ResponseStatusException(HttpStatus.NOT_FOUND, "Food not found.")
    );
    
  }

  //Delete food entries
  @DeleteMapping(value = "/{id}", produces = "application/json")
  public void deleteFoodEntry(@PathVariable final Long id) {
    foodEntryDao.deleteById(id);
  }
}