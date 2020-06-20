package com.orsolyazolcsak.allamvizsga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orsolyazolcsak.allamvizsga.model.User;
import com.orsolyazolcsak.allamvizsga.service.LoginUserDao;
import com.orsolyazolcsak.allamvizsga.service.UserService;

@RestController
@RequestMapping("/login")
public class LoginController {

  private final UserService userService;

  @Autowired
  public LoginController(UserService userService) {
    this.userService = userService;
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @PostMapping(consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
  public ResponseEntity<User> loginUser(LoginUserDao loginUserDao) {
    System.out.println("post called");
    boolean userExists = this.userService.checkUser(loginUserDao.getUsername(),
        loginUserDao.getPassword());
    if (userExists) {
      User user = this.userService.findByUsername(loginUserDao.getUsername()).get();

      return new ResponseEntity<>(user, HttpStatus.OK);
    } else {
      System.out.println(loginUserDao);
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

  }

  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping
  public ResponseEntity<User> neszeUser() {
    System.out.println("get called");
    User proba = new User();
    proba.setUsername("Jancsi");
    return new ResponseEntity<>(proba, HttpStatus.ACCEPTED);
  }

  // @CrossOrigin(origins = "http://localhost:3000")
  // @PostMapping
  // public ResponseEntity<User> loginUser2(LoginUserDao loginUserDao) {
  // System.out.println("post called2" + loginUserDao);
  // return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
  // }

}
