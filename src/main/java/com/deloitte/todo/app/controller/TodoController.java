package com.deloitte.todo.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.deloitte.todo.app.exception.TargetDateException;
import com.deloitte.todo.app.model.TodoList;
import com.deloitte.todo.app.repository.TodoRepository;
import com.deloitte.todo.app.service.TodoService;
import com.deloitte.todo.app.util.Util;

@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	TodoService todoService;

	@Autowired
	TodoRepository todoRepo;
	
	//getting the object of the Util class
	Util util = Util.getInstance();

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	// fetch all the todos based on username
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String fetchTodos(ModelMap model) {
		String name = (String) model.get("name");
		List<TodoList> todoList = todoService.findTodoByUserName(name);
		model.put("name", name);
		model.put("todos", todoList);
		return "list-todos.jsp";
	}

	// redirect to todo.jsp page
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		model.addAttribute("todo", new TodoList());
		return "todo.jsp";
	}

	// delete the selected todos
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodo(id);
		return "redirect:/list-todos";
	}

	// redirect to todo.jsp
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		TodoList todo = todoService.getTodoById(id).get();
		model.put("todo", todo);
		return "todo.jsp";
	}

	// update a selected todo
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid TodoList todo, BindingResult result) throws TargetDateException {
		if (result.hasErrors()) {
			return "todo";
		}

		boolean isValidTargetDate = util.checkTargetDate(todo.getTargetDate(), todo.getUpdatedDate());

		if (!isValidTargetDate) {

			throw new TargetDateException("Please select a valid target date");

		}

		String name = (String) model.get("name");
		todo.setUserName(name);
		todoService.updateTodo(todo);
		return "redirect:/list-todos";

	}

	// add a new todo for a user
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid TodoList todo, BindingResult result) {

		if (result.hasErrors()) {
			return "todo";
		}
		String name = (String) model.get("name");
		todo.setUserName(name);
		todoService.saveTodo(todo);
		return "redirect:/list-todos";
	}
}