package com.orsolyazolcsak.allamvizsga.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orsolyazolcsak.allamvizsga.model.Problem;
import com.orsolyazolcsak.allamvizsga.model.Test;
import com.orsolyazolcsak.allamvizsga.service.ProblemService;
import com.orsolyazolcsak.allamvizsga.service.TestService;

@RestController
@RequestMapping("/problem")
public class ProblemController {

  @Autowired
  private ProblemService problemService;

  @Autowired
  private TestService testService;

  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping
  public List<Problem> getTests() {
    Optional<Test> running = this.testService.findRunning();
    if (running.isPresent()) {
      return this.problemService.getAllProblemsByTest(running.get().getId());
    }
    return new ArrayList<>();
  }

  @PostMapping
  Problem newProblem(@RequestBody Problem newProblem) {
    return this.problemService.createNewProblem(newProblem);
  }

  @GetMapping("/{id}")
  Optional<Problem> one(@PathVariable Long id) {

    return this.problemService.findById(id);
    // .orElseThrow(()-> new ProblemNotFoundException(id));
  }

  @DeleteMapping("/{id}")
  void deleteProblem(@PathVariable Long id) {
    this.problemService.deleteById(id);
  }
}
