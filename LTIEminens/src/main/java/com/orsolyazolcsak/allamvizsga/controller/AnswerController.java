/*
 * Copyright (C) TBA BV
 * All rights reserved.
 * www.tba.nl
 */
package com.orsolyazolcsak.allamvizsga.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orsolyazolcsak.allamvizsga.model.Answer;
import com.orsolyazolcsak.allamvizsga.service.AnswerDao;
import com.orsolyazolcsak.allamvizsga.service.AnswerService;
import com.orsolyazolcsak.allamvizsga.service.ProblemService;
import com.orsolyazolcsak.allamvizsga.service.UserAnswer;
import com.orsolyazolcsak.allamvizsga.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/answer")
public class AnswerController {

  @Autowired
  private AnswerService answerService;

  @Autowired
  private ProblemService problemService;

  @Autowired
  private UserService userService;

  @GetMapping("/{problemID}")
  public List<UserAnswer> getUserAnswers(@PathVariable long problemID) {
    return this.answerService.findByProblemId(problemID).stream() //
        .map(answer -> new UserAnswer(this.userService.findById(
            answer.getUserId()).get().getFullName(), answer.getAnswer())) //
        .collect(Collectors.toList());
  }

  @PostMapping
  public void saveAnswer(AnswerDao answerDao) {
    Answer answer = new Answer();
    answer.setAnswer(answerDao.getAnswer());
    answer.setProblemId(answerDao.getProblemId());
    answer.setUserId(answerDao.getUserId());
    this.answerService.saveAnswer(answer);
  }
}
