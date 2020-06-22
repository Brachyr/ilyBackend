/*
 * Copyright (C) TBA BV
 * All rights reserved.
 * www.tba.nl
 */
package com.orsolyazolcsak.allamvizsga.service;

import java.util.List;

import com.orsolyazolcsak.allamvizsga.model.Answer;

public interface AnswerService {

  public List<Answer> findByProblemId(long problemID);

  public void saveAnswer(Answer answer);

  public List<Answer> findForLastProblem();
}
