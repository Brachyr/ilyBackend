package com.orsolyazolcsak.allamvizsga.service;

import java.util.List;
import java.util.Optional;

import com.orsolyazolcsak.allamvizsga.model.Test;

public interface TestService {
  List<Test> findAll();

  void createNewTest(Test newTest);

  Optional<Test> findRunning();
}
