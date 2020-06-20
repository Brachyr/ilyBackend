package com.orsolyazolcsak.allamvizsga;

import com.orsolyazolcsak.allamvizsga.service.DifficultyService;
import com.orsolyazolcsak.allamvizsga.service.ProblemService;
import com.orsolyazolcsak.allamvizsga.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	ProblemService problemService;
	@Autowired
	DifficultyService difficultyService;
	@Autowired
	UserService userService;

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	 @Override
	    public void run(String... arg0) throws Exception {

	        List<String> problems = problemService.getAllProblemsByTest(1001);
	        for(String problem : problems)
	        {
	            System.out.println("Easy questions => " + problem);
	        }
	        List<String> difficulties = difficultyService.getAllDifficulties();
	        for(String difficulty : difficulties)
	        {
	        	System.out.println("Difficulty: " + difficulty);
	        }
	        userService.findAll().forEach(u -> u.getPassword());
	        
	    }
}
