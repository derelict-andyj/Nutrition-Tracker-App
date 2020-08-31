package com.derelictmansion.nutrition.data.dao;

import com.derelictmansion.nutrition.data.models.FoodEntry;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface FoodEntryDao extends CrudRepository<FoodEntry, Long> {

  public Optional<FoodEntry> getByName(String name);

}
