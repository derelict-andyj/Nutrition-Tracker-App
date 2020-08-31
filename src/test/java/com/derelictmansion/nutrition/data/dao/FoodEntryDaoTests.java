package com.derelictmansion.nutrition.data.dao;

import com.derelictmansion.nutrition.data.models.FoodEntry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.*;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FoodEntryDaoTests {

  @Autowired
  private FoodEntryDao foodEntryDao;

  @Test
  public void whenIdExists_thenReturnOne() throws Exception {
    Optional<FoodEntry> foodEntryId = foodEntryDao.findById(8L);
    assertThat(foodEntryId).isNotEmpty();
  }

  @Test
  public void whenNameExists_thenReturnOne() throws Exception {
    Optional<FoodEntry> foodEntry = foodEntryDao.getByName("Bacon");
    assertThat(foodEntry).isNotNull();
  }

  @Test
  public void whenNameDoesNotExist_thenReturnEmpty () { 
    Optional<FoodEntry> foodEntry = foodEntryDao.getByName("Chips");
    assertThat(foodEntry).isEmpty();
  
  }

}