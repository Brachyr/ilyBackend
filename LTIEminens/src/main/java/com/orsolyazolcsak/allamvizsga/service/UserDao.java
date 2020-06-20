package com.orsolyazolcsak.allamvizsga.service;

public class UserDao {
  private Long id;

  private String username;

  private String password;

  private String salt;

  private String fullName;

  private String role;

  public UserDao() {
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSalt() {
    return this.salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  public String getFullName() {
    return this.fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getRole() {
    return this.role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return "UserDao{" + "id=" + this.id + ", username='" + this.username + '\'' + ", password='"
        + this.password + '\'' + ", salt='" + this.salt + '\'' + ", fullName='" + this.fullName
        + '\'' + ", roleId=" + this.role + '}';
  }
}
