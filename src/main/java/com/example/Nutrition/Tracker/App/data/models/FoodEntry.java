package com.example.Nutrition.Tracker.App.data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name = "f_food")
public class FoodEntry {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @JsonProperty(access = Access.READ_ONLY)
  private Long id;
  
  @NotNull
  @Column(name = "name")
  private String name;
  @NotNull
  @Column(name = "description")
  private String description;
  @NotNull
  @Column(name ="calories")
  private Long calories;
  @NotNull
  @Column(name = "fat")
  private int fat;
  @NotNull
  @Column(name = "protien")
  private int protien;
  @NotNull
  @Column(name = "carbs")
  private int carbs;
  @NotNull
  @Column(name = "servings")
  private int servings;

  protected FoodEntry() {}

  public int getCarbs() {
    return carbs;
  }

  public Long getCalories() {
    return calories;
  }

  public void setCalories(Long calories) {
    this.calories = calories;
  }

  public int getFat() {
    return fat;
  }

  public void setFat(int fat) {
    this.fat = fat;
  }

  public int getProtien() {
    return protien;
  }

  public void setProtien(int protien) {
    this.protien = protien;
  }

  public void setCarbs(int carbs) {
    this.carbs = carbs;
  }
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getServings() {
    return servings;
  }

  public void setServings(int servings) {
    this.servings = servings;
  }
}