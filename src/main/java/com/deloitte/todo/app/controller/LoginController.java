package com.deloitte.todo.app.controller;

import com.deloitte.todo.app.model.User;
import com.deloitte.todo.app.repository.UserRepository;
import com.deloitte.todo.app.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.deloitte.todo.app.service.LoginService;

@Controller
@SessionAttributes({ "name", "password" })
public class LoginController {

	@Autowired
	LoginService loginService;

	// method to display the login page
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		return "Login.jsp";
	}

	// authenticate user using BCrypt for security
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String showHomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {

		try {
			boolean isValidUser = loginService.validateUser(name, password);
			if (!isValidUser) {
				model.put("errorMessage", "Invalid Credentials");
				return "Login.jsp";
			}
			model.put("name", name);
			model.put("password", password);
			return "Home.jsp";

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}

	}
}
