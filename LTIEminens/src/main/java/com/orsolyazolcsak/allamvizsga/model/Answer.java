package com.orsolyazolcsak.allamvizsga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Answer {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "answer")
  private String answer;

  @Column(name = "user_id")
  private long userId;

  @Column(name = "problem_id")
  private long problemId;

  public Answer() {

  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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