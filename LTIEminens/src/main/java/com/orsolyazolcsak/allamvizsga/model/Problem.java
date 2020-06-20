package com.orsolyazolcsak.allamvizsga.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Problem {
  @Id
  @Column(name = "problem_id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "problem_Sequence")
  @SequenceGenerator(name = "problem_Sequence", sequenceName = "PROBLEM_SEQ")
  private Long id;

  @Column(name = "question")
  private String question;

  @Column(name = "correct_answer")
  private String correctAnswer;

  @Column(name = "incorrect_answer1")
  private String incorrectAnswer1;

  @Column(name = "incorrect_answer2")
  private String incorrectAnswer2;

  @Column(name = "incorrect_answer3")
  private String incorrectAnswer3;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "problem")
  private List<UsedHelp> usedHelp;

  @Column(name = "difficulty")
  private String difficulty;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "problem")
  private List<Answer> answer;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "test_id", nullable = false)
  private Test test;

  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(name = "Test_ready_to_take_Problem", joinColumns = {
      @JoinColumn(name = "problem_id") }, inverseJoinColumns = {
          @JoinColumn(name = "test_ready_to_take_id") })
  Set<TestReadyToTake> testsReadyToTake = new HashSet<>();

  public Problem() {

  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public String getCorrectAnswer() {
    return this.correctAnswer;
  }

  public void setCorrectAnswer(String correctAnswer) {
    this.correctAnswer = correctAnswer;
  }

  public String getIncorrectAnswer1() {
    return this.incorrectAnswer1;
  }

  public void setIncorrectAnswer1(String incorrectAnswer1) {
    this.incorrectAnswer1 = incorrectAnswer1;
  }

  public String getIncorrectAnswer2() {
    return this.incorrectAnswer2;
  }

  public void setIncorrectAnswer2(String incorrectAnswer2) {
    this.incorrectAnswer2 = incorrectAnswer2;
  }

  public String getIncorrectAnswer3() {
    return this.incorrectAnswer3;
  }

  public void setIncorrectAnswer3(String incorrectAnswer3) {
    this.incorrectAnswer3 = incorrectAnswer3;
  }

  public List<UsedHelp> getUsedHelp() {
    return this.usedHelp;
  }

  public void setUsedHelp(List<UsedHelp> usedHelp) {
    this.usedHelp = usedHelp;
  }

  public String getDifficulty() {
    return this.difficulty;
  }

  public void setDifficulty(String difficulty) {
    this.difficulty = difficulty;
  }

  public List<Answer> getAnswer() {
    return this.answer;
  }

  public void setAnswer(List<Answer> answer) {
    this.answer = answer;
  }

  public Test getTest() {
    return this.test;
  }

  public void setTest(Test test) {
    this.test = test;
  }

  public Set<TestReadyToTake> getTestsReadyToTake() {
    return this.testsReadyToTake;
  }

  public void setTestsReadyToTake(Set<TestReadyToTake> testsReadyToTake) {
    this.testsReadyToTake = testsReadyToTake;
  }

  public Long getId() {
    return this.id;
  }

  public String getQuestion() {
    return this.question;
  }

}