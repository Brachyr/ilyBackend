/*
 * Copyright (C) TBA BV
 * All rights reserved.
 * www.tba.nl
 */
package com.orsolyazolcsak.allamvizsga.service;

public class AnswerDao {
  public String answer;

  public long problem_id;

  public long user_id;

  public String getAnswer() {
    return this.answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public long getProblem_id() {
    return this.problem_id;
  }

  public void setProblem_id(long problem_id) {
    this.problem_id = problem_id;
  }

  public long getUser_id() {
    return this.user_id;
  }

  public void setUser_id(long user_id) {
    this.user_id = user_id;
  }
}