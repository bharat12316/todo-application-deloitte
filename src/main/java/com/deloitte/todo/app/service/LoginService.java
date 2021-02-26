package com.deloitte.todo.app.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.deloitte.todo.app.model.User;
import com.deloitte.todo.app.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	UserRepository userRepo;

	// authenticate the user using Bcrypt
	public boolean validateUser(String name, String password) {
		String userName = "";
		String pwd = "";

		try {

			User user = userRepo.findByUserName(name);

			if (user != null ){

				userName = user.getUserName();

				pwd = user.getPassword();
			} else {

				return false;
			}

			if (name.equals(userName)) {

				if (BCrypt.checkpw(password, pwd))

					return true;

			}

			return false;
		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		}

	}

}
