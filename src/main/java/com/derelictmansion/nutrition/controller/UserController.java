package com.derelictmansion.nutrition.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import com.derelictmansion.nutrition.data.dao.UserDao;
import com.derelictmansion.nutrition.data.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(value = "/users")
public class UserController {

  
	private UserDao userDao;
	public UserController(UserDao userDao) {
    this.userDao = userDao;
  }
	@GetMapping(value = "/{id}", produces = "application/json")
  public User getUser(@PathVariable final Long id) {
    User foundUser = userDao.getById(id);
    if (foundUser != null) {
      return foundUser;
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
    }
  }
	@GetMapping(produces = "application/json")
  public List<User> getUsers() {
    return userDao.findAllUsers();
  }


	//TODO add more mappings here for get users, users by id, add users, update users, delete users


}