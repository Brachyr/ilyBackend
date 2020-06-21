package com.orsolyazolcsak.allamvizsga.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orsolyazolcsak.allamvizsga.model.Test;
import com.orsolyazolcsak.allamvizsga.repository.TestRepository;

@Service
public class TestServiceImpl implements TestService {

  @Autowired
  private TestRepository repository;

  @Override
  public List<Test> findAll() {
    return new ArrayList(this.repository.findAll());
  }

  @Override
  public void createNewTest(Test newTest) {
    this.repository.save(newTest);
  }

  @Override
  public Optional<Test> findRunning() {
    return this.findAll().stream().filter(t -> "on".equals(t.getState())).findFirst();
  }

  @Override
  public Optional<Test> findById(long id) {
    return this.repository.findById(id);
  }

  @Override
  public void delete(Test test) {
    this.repository.delete(test);
  }

  @Override
  public void deleteById(long id) {
    this.repository.deleteById(id);
  }
}
