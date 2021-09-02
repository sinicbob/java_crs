package ru.stqa.pft.mantis.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mantis_user_table")
public class UserData {
  @Id
  private int id = Integer.MAX_VALUE;
  private String username;
  private String email;

  public int getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getUsername() {
    return username;
  }
}
