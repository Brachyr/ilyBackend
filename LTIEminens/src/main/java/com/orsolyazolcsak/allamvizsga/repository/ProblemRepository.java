package com.orsolyazolcsak.allamvizsga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.orsolyazolcsak.allamvizsga.model.Problem;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {
	List<Problem> findByDifficulty(String difficultyId);
	List<Problem> findByTestId(long testId);

}
