package com.derelictmansion.nutrition.controller;

import java.util.List;

import javax.validation.Valid;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import com.derelictmansion.nutrition.data.dao.FoodEntryDao;
import com.derelictmansion.nutrition.data.models.FoodEntry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

  //Add food entries
  @PostMapping(consumes = "application/json", produces = "application/json")
  public void addFoodEntry(@Valid @RequestBody final FoodEntry foodEntry) {
    foodEntryDao.save(foodEntry);
  }
}