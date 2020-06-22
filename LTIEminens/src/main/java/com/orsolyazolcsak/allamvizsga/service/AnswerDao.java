/*
 * Copyright (C) TBA BV
 * All rights reserved.
 * www.tba.nl
 */
package com.orsolyazolcsak.allamvizsga.service;

public class AnswerDao {
  private String answer;

  private long userId;

  private long problemId;

  public String getAnswer() {
    return this.answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public long getUserId() {
    return this.userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public long getProblemId() {
    return this.problemId;
  }

  public void setProblemId(long problemId) {
    this.problemId = problemId;
  }
}
