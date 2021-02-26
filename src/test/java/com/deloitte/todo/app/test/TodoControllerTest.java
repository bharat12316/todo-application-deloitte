package com.deloitte.todo.app.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.deloitte.todo.app.model.TodoList;
import com.deloitte.todo.app.repository.*;
import com.deloitte.todo.app.service.TodoService;
import com.deloitte.todo.app.util.Util;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { TodoRepository.class, TodoService.class })
public class TodoControllerTest {

	@Autowired
	private TodoService todoservice;

	@MockBean
	private TodoRepository repository;

	Util util = Util.getInstance();

	String name = "Arvind";

	@Test
	public void getTodobyUserNameTest() throws ParseException {
		when(repository.findByUserName(name))
				.thenReturn(Stream.of(new TodoList("Arvind", "Joggin daily", util.convertStringToDate("21/06/2019"),
						util.convertStringToDate("21/06/2019"),false)).collect(Collectors.toList()));
		assertEquals(1, todoservice.findTodoByUserName(name).size());
	}

	@Test
	public void saveTodoTest() throws ParseException {
		TodoList todo = new TodoList("Mark", " walking exercise", util.convertStringToDate("06/06/2020"),
				util.convertStringToDate("03/06/2020"),false);
		when(repository.save(todo)).thenReturn(todo);
		assertEquals(todo, todoservice.saveTodo(todo));
	}

	@Test
	public void updateTodoTest() throws ParseException {

		TodoList todo = new TodoList("Mark", " walking exercise", util.convertStringToDate("06/06/2020"),
				util.convertStringToDate("03/06/2020"),false);
		todoservice.saveTodo(todo);
		verify(repository, times(1)).save(todo);

	}

}