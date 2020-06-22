package com.orsolyazolcsak.allamvizsga.model;

import static com.orsolyazolcsak.allamvizsga.service.UserServiceImpl.generateSalt;
import static com.orsolyazolcsak.allamvizsga.service.UserServiceImpl.hashPassword;

import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_eminens")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "salt", length = 4000)
  private String salt;

  @Column(name = "full_name")
  private String fullName;

  @JoinColumn(name = "role", nullable = false)
  private String role;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
  private List<UsedHelp> usedHelp;

  public User() {

  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPassword() {
    return this.password;
  }

  public String getSalt() {
    return this.salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  public List<UsedHelp> getUsedHelp() {
    return this.usedHelp;
  }

  public void setUsedHelp(List<UsedHelp> usedHelp) {
    this.usedHelp = usedHelp;
  }

  public Long getId() {
    return this.id;
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

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {

    Optional<String> salt = generateSalt(512);

    if (salt.isPresent()) {

      Optional<String> securedPassword = hashPassword(password, salt.get());

      if (securedPassword.isPresent()) {
        this.salt = salt.get();
        this.password = securedPassword.get();
      } else {
        System.out.println("Error in setPassword: hashPassword");
      }
    } else {
      System.out.println("Error in setPassword: generateSalt");
    }

  }
}