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
import com.orsolyazolcsak.allamvizsga.service.LoginUserDao;
import com.orsolyazolcsak.allamvizsga.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {

  @Autowired
  private UserService userService;

  @PostMapping(consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
  public ResponseEntity<User> loginUser(LoginUserDao loginUserDao) {
    boolean userExists = this.userService.checkUser(loginUserDao.getUsername(),
        loginUserDao.getPassword());
    if (userExists) {
      User user = this.userService.findByUsername(loginUserDao.getUsername()).get();
      return new ResponseEntity<>(user, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
  }
}
