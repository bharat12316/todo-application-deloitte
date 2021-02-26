package com.deloitte.todo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.deloitte.todo.app.model.TodoList;
import com.deloitte.todo.app.model.User;
import com.deloitte.todo.app.repository.TodoRepository;
import com.deloitte.todo.app.repository.UserRepository;
import com.deloitte.todo.app.util.Util;
import org.springframework.web.bind.annotation.PostMapping;

@SpringBootApplication

public class TodoApp extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	TodoRepository todoRepo;

	@Autowired
	UserRepository userRepo;

	// getting the instance of the Util class
	Util util = Util.getInstance();

	public static void main(String[] args) {
		SpringApplication.run(TodoApp.class, args);
	}

	// Hardcoding the list of users and todos at the start of the application
	@Override
	public void run(String... args) throws Exception {

		userRepo.save(new User("Bharat", util.hashPwd("bharat@123")));
		userRepo.save(new User("Mark", util.hashPwd("mark@123")));
		userRepo.save(new User("Rock", util.hashPwd("rock@123")));
		userRepo.save(new User("Eoin", util.hashPwd("eoin@123")));
		userRepo.save(new User("Erik", util.hashPwd("erik@123")));

		todoRepo.save(new TodoList("Bharat", "Daily Workout", util.convertStringToDate("20/02/2020"),
				util.convertStringToDate("15/06/2019"),false));
		todoRepo.save(new TodoList("Mark", " walking exercise", util.convertStringToDate("06/06/2020"),
				util.convertStringToDate("03/06/2020"),false));
		todoRepo.save(new TodoList("Mark", "Gym", util.convertStringToDate("06/06/2020"),
				util.convertStringToDate("03/06/2020"),false));
		todoRepo.save(new TodoList("Rock", "Studying", util.convertStringToDate("06/06/2020"),
				util.convertStringToDate("03/06/2020"),false));
		todoRepo.save(new TodoList("Rock", "Meditation", util.convertStringToDate("06/06/2020"),
				util.convertStringToDate("03/06/2020"),false));
		todoRepo.save(new TodoList("Eoin", "Swimming", util.convertStringToDate("06/06/2020"),
				util.convertStringToDate("03/06/2020"),false));
		todoRepo.save(new TodoList("Eoin", "Practice Programming", util.convertStringToDate("06/06/2020"),
				util.convertStringToDate("03/06/2020"),false));
		todoRepo.save(new TodoList("Erik", "Cycling", util.convertStringToDate("06/06/2020"),
				util.convertStringToDate("03/06/2020"),false));
		todoRepo.save(new TodoList("Erik", "Yoga", util.convertStringToDate("06/06/2020"),
				util.convertStringToDate("03/06/2020"),false));

	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(TodoApp.class);

	}


}