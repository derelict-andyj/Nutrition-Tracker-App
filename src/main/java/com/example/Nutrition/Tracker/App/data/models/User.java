package com.example.Nutrition.Tracker.App.data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "c_user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @JsonProperty(access = Access.READ_ONLY)
  private Long id;
  @Size(min = 1)
  @Column(name = "first_name")
  private String firstname;
  
  @Size(min = 1)
  @Column(name = "last_name")
  private String lastname;
  @NotNull
  @Email
  private String email;
  @NotNull
  @Column(name = "weight")
  private int weight;
  @NotNull
  @Column(name = "height")
  private String height;

 
  
  protected User() {}

  

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstname;
  }

  public void setFirstName(String firstname) {
    this.firstname = firstname;
  }

  public String getLastName() {
    return lastname;
  }

  public void setLastName(String lastname) {
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public String getHeight() {
    return height;
  }

  public void setHeight(String height) {
    this.height = height;
  }

}