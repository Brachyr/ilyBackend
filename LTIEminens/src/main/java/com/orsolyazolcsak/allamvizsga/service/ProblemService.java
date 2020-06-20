package com.orsolyazolcsak.allamvizsga.service;

import com.orsolyazolcsak.allamvizsga.model.Problem;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProblemService {

	Set<Problem> findAll();

	Problem createNewProblem(Problem newProblem);

	Optional<Problem> findById(Long id);

	public List<Problem> getAllProblemsByDifficulty(String difficulty);

	public List<Problem> getAllProblemsByTest(long testId);

	void deleteById(long id);

}
