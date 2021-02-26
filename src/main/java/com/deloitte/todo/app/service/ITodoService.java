package com.deloitte.todo.app.service;

import java.util.List;
import java.util.Optional;

import com.deloitte.todo.app.model.TodoList;

public interface ITodoService {

	List<TodoList> findTodoByUserName(String name);

	Optional<TodoList> getTodoById(int id);

	void updateTodo(TodoList todo);

	void deleteTodo(int id);

	TodoList saveTodo(TodoList todo);

}