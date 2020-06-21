/*
 * Copyright (C) TBA BV
 * All rights reserved.
 * www.tba.nl
 */
package com.orsolyazolcsak.allamvizsga.service;

import java.util.List;

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
  public void saveAnswer(Answer answer) {
    this.answerRepository.save(answer);
  }
}
