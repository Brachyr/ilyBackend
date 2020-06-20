package com.orsolyazolcsak.allamvizsga;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.orsolyazolcsak.allamvizsga.service.ProblemService;
import com.orsolyazolcsak.allamvizsga.service.UserService;

@SpringBootApplication
public class Application implements CommandLineRunner {

  @Autowired
  ProblemService problemService;

  @Autowired
  UserService userService;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... arg0) throws Exception {

    List<String> problems = this.problemService.getAllProblemsByTest(1001);
    for (String problem : problems) {
      System.out.println("Easy questions => " + problem);
    }

  }
}
