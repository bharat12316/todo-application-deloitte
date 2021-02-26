package com.deloitte.todo.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.todo.app.model.TodoList;

import com.deloitte.todo.app.repository.TodoRepository;

@Service
public class TodoService implements ITodoService {

	// injecting the repository object
	@Autowired
	TodoRepository todoRepository;

	// fetch the todos based on userName
	public List<TodoList> findTodoByUserName(String name) {
		return todoRepository.findByUserName(name);

	}

	// update todo
	@Override
	public void updateTodo(TodoList todo) {
		todoRepository.save(todo);

	}

	// delete a todo from DB
	@Override
	public void deleteTodo(int id) {
		Optional<TodoList> todo = todoRepository.findById(id);
		if (todo.isPresent()) {
			todoRepository.delete(todo.get());
		}

	}

	// add a new todo to DB
	@Override
	public TodoList saveTodo(TodoList todo) {
		return todoRepository.save(todo);
	}

	// fetch a todo based on id
	@Override
	public Optional<TodoList> getTodoById(int id) {
		return todoRepository.findById(id);
	}

}