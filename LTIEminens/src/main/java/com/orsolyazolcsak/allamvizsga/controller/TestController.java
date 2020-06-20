package com.orsolyazolcsak.allamvizsga.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orsolyazolcsak.allamvizsga.model.Test;
import com.orsolyazolcsak.allamvizsga.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {

  @Autowired
  private TestService testService;

  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping
  public ResponseEntity<List<Test>> getTests() {
    return new ResponseEntity<>(this.testService.findAll(), HttpStatus.ACCEPTED);
  }

  @PostMapping
  public ResponseEntity<Test> newTest(@RequestBody Test newTest) {
    this.testService.createNewTest(newTest);
    return new ResponseEntity<>(newTest, HttpStatus.CREATED);
  }

  @GetMapping("/running")
  public Optional<Test> getRunning() {
    return this.testService.findRunning();
  }

}
