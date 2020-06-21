package com.orsolyazolcsak.allamvizsga.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orsolyazolcsak.allamvizsga.model.Problem;
import com.orsolyazolcsak.allamvizsga.repository.ProblemRepository;

@Service
public class ProblemServiceImpl implements ProblemService {

  @Autowired
  private ProblemRepository repository;

  @Override
  public List<Problem> findAll() {
    return new ArrayList<>(this.repository.findAll());
  }

  @Override
  public Problem createNewProblem(Problem newProblem) {
    this.repository.save(newProblem);
    return newProblem;
  }

  @Override
  public Optional<Problem> findById(Long id) {
    return this.repository.findById(id);
  }

  public List<Problem> getAllProblemsByTest(long testId) {
    return this.repository.findByTestId(testId);
  }

  @Override
  public void deleteById(long id) {
    this.repository.deleteById(id);
  }

  public List<Problem> getAllProblemsByDifficulty(String difficulty) {
    return this.repository.findByDifficulty(difficulty);
  }
}
