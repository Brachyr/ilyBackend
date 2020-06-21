package com.orsolyazolcsak.allamvizsga.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orsolyazolcsak.allamvizsga.model.Test;
import com.orsolyazolcsak.allamvizsga.service.TestService;

@CrossOrigin()
@RestController
@RequestMapping("/test")
public class TestController {

  @Autowired
  private TestService testService;

  @GetMapping
  public ResponseEntity<List<Test>> getTests() {
    List<Test> tests = this.testService.findAll();
    MultiValueMap<String, String> headers = new HttpHeaders();
    headers.add("Access-Control-Expose-Headers", "Content-Range");
    headers.add("Content-Range", "tests 0-9/" + tests.size());
    return new ResponseEntity<>(this.testService.findAll(), headers, HttpStatus.ACCEPTED);
  }

  @PostMapping
  public ResponseEntity<Test> newTest(@RequestBody Test newTest) {
    this.testService.createNewTest(newTest);
    return new ResponseEntity<>(newTest, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Test> editTest(@RequestBody Test test) {
    this.testService.createNewTest(test);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/running")
  public Optional<Test> getRunning() {
    return this.testService.findRunning();
  }

  @GetMapping("/{id}")
  public Optional<Test> getTest(@PathVariable("id") Long id) {
    return this.testService.findById(id);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteTest(@PathVariable("id") Long id) {
    this.testService.deleteById(id);
    return ResponseEntity.ok().build();
  }
}
