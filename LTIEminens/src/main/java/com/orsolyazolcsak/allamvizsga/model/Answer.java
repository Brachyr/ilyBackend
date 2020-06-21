package com.orsolyazolcsak.allamvizsga.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@Column(name = "answer_is_correct")
	private boolean answerIsCorrect;
	
	@OneToMany(cascade = CascadeType.ALL,
	            fetch = FetchType.EAGER,
	            mappedBy = "answer")
	    private List<UsedHelp> usedHelp;
	 
	@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "user_id", nullable = false)
		private User user;
		
	@ManyToOne(fetch = FetchType.LAZY)
    	@JoinColumn(name = "problem_id", nullable = false)
		private Problem problem;
		
	@ManyToOne(fetch = FetchType.LAZY)
    	@JoinColumn(name = "test_ready_to_take_id", nullable = false)
		private TestReadyToTake testReadyToTake;
		
		
	public Answer() {
		 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isAnswerIsCorrect() {
		return answerIsCorrect;
	}

	public void setAnswerIsCorrect(boolean answerIsCorrect) {
		this.answerIsCorrect = answerIsCorrect;
	}

	public List<UsedHelp> getUsedHelp() {
		return usedHelp;
	}

	public void setUsedHelp(List<UsedHelp> usedHelp) {
		this.usedHelp = usedHelp;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Problem getProblem() {
		return problem;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}

	public TestReadyToTake getTestReadyToTake() {
		return testReadyToTake;
	}

	public void setTestReadyToTake(TestReadyToTake testReadyToTake) {
		this.testReadyToTake = testReadyToTake;
	}

	public boolean getAnswerIsCorrect() {
		return answerIsCorrect;
	}
}