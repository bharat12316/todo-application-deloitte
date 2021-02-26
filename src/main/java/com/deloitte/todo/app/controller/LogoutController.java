package com.deloitte.todo.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {

	// invalidate the session and logout the user
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutUser(HttpSession session) {
		try {

			session.invalidate();

		} catch (IllegalStateException e) {

			e.printStackTrace();

			throw e;

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}

		return "redirect:/login";

	}

}
