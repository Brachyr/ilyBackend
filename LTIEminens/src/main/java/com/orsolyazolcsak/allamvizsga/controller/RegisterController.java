package com.orsolyazolcsak.allamvizsga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orsolyazolcsak.allamvizsga.model.User;
import com.orsolyazolcsak.allamvizsga.service.UserDao;
import com.orsolyazolcsak.allamvizsga.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/register")
public class RegisterController {

  @Autowired
  private UserService userService;

  @PostMapping(consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
  public ResponseEntity<User> newUser(UserDao newUserDao) {
    if (this.userService.findByUsername(newUserDao.getUsername()).isPresent()) {
      return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    }
    User newUser = new User();
    newUser.setRole(newUserDao.getRole());
    newUser.setUsername(newUserDao.getUsername());
    newUser.setPassword(newUserDao.getPassword());
    newUser.setFullName(newUserDao.getFullName());
    this.userService.createNewUser(newUser);
    return new ResponseEntity<>(newUser, HttpStatus.CREATED);
  }
}
