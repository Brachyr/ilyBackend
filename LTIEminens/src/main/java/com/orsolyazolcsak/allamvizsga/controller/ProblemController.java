package com.orsolyazolcsak.allamvizsga.controller;

import java.util.ArrayList;
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

import com.orsolyazolcsak.allamvizsga.model.Problem;
import com.orsolyazolcsak.allamvizsga.model.Test;
import com.orsolyazolcsak.allamvizsga.service.ProblemService;
import com.orsolyazolcsak.allamvizsga.service.TestService;

@CrossOrigin
@RestController
@RequestMapping("/problem")
public class ProblemController {

  @Autowired
  private ProblemService problemService;

  @Autowired
  private TestService testService;

  @GetMapping
  public ResponseEntity<List<Problem>> getProblems() {
    Optional<Test> running = this.testService.findRunning();
    this.problemService.findAll();
    List<Problem> ret;
    if (running.isPresent()) {
      ret = this.problemService.getAllProblemsByTest(running.get().getId());
    } else {
      ret = new ArrayList<>();
    }
    MultiValueMap<String, String> headers = new HttpHeaders();
    headers.add("Access-Control-Expose-Headers", "Content-Range");
    headers.add("Content-Range", "tests 0-9/" + ret.size());
    return new ResponseEntity<>(ret, headers, HttpStatus.ACCEPTED);
  }

  @GetMapping("/active")
  public List<Problem> getActive() {
    Optional<Test> running = this.testService.findRunning();
    if (running.isPresent()) {
      return this.problemService.getAllProblemsByTest(running.get().getId());
    }
    return new ArrayList<>();
  }

  @PostMapping
  public Problem newProblem(@RequestBody Problem newProblem) {
    return this.problemService.createNewProblem(newProblem);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Test> editProblem(@RequestBody Problem problem) {
    this.problemService.createNewProblem(problem);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/{id}")
  public Optional<Problem> one(@PathVariable Long id) {
    return this.problemService.findById(id);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteProblem(@PathVariable Long id) {
    this.problemService.deleteById(id);
    return ResponseEntity.ok().build();
  }
}
