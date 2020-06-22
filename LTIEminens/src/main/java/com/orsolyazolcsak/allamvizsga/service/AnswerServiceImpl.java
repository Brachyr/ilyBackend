/*
 * Copyright (C) TBA BV
 * All rights reserved.
 * www.tba.nl
 */
package com.orsolyazolcsak.allamvizsga.service;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orsolyazolcsak.allamvizsga.model.Answer;
import com.orsolyazolcsak.allamvizsga.repository.AnswerRepository;

@Service
public class AnswerServiceImpl implements AnswerService {

  @Autowired
  private AnswerRepository answerRepository;

  @Override
  public List<Answer> findByProblemId(long problemID) {
    return this.answerRepository.findByProblemId(problemID);
  }

  @Override
  public List<Answer> findForLastProblem() {
    OptionalLong lastProblem = this.answerRepository.findAll().stream().mapToLong(
        Answer::getProblemId).max();
    if (lastProblem.isPresent()) {
      return this.findByProblemId(lastProblem.getAsLong());
    }
    return new ArrayList<>();
  }

  @Override
  public void saveAnswer(Answer answer) {
    this.answerRepository.save(answer);
  }
}
