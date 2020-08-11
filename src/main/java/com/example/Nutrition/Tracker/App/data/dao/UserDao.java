package com.example.Nutrition.Tracker.App.data.dao;


import java.util.List;

import com.example.Nutrition.Tracker.App.data.models.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> {

  @Query(value = "select * from c_user u where u.id = :id", nativeQuery = true)
  public User getById(Long id);

  @Query(value = "select * from c_user", nativeQuery = true)
  public List<User> findAllUsers();

  public default void deleteById(Long id) {
    User user = this.getById(id);
    save(user);
  }

  @Query(value = "select * from c_user u where u.email = :email", nativeQuery = true)
  public User getByEmail(String email);

}