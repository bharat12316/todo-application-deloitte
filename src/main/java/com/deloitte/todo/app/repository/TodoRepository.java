package com.deloitte.todo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deloitte.todo.app.model.TodoList;

public interface TodoRepository extends JpaRepository<TodoList, Integer> {

	//search using the userName
	List<TodoList> findByUserName(String userName);

	
}