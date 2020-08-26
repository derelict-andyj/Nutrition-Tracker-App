package com.derelictmansion.nutrition.data.dao;

import com.derelictmansion.nutrition.data.models.FoodEntry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface FoodEntryDao extends CrudRepository<FoodEntry, Long> {
  

  @Query(value = "select * from f_food f where f.id =:id", nativeQuery = true)
  public FoodEntry getById(Long id);

  @Query(value = "select * from f_food", nativeQuery = true)
  public List<FoodEntry> findAllFoods();

//TODO: getByName here?
  @Query(value ="select * from f_food f where f.name =:name", nativeQuery = true)  
  public FoodEntry getByName(String name);
  
  public default void deleteById(Long id) {
    FoodEntry food = this.getById(id);
    save(food);
  }

}
