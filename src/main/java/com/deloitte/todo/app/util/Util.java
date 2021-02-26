package com.deloitte.todo.app.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.mindrot.jbcrypt.BCrypt;

public class Util {

	// creating an object of the Util class
	private static final Util util = new Util();

	// making the constructor private such that this class cannot instantiated
	private Util() {

	}

	// Get the only object available
	public static Util getInstance() {

		return util;
	}

	// generating a Bcrypt hashed password for security purposes
	// the encrypted password will be stored in DB
	public String hashPwd(String pwd) {
		return BCrypt.hashpw(pwd, BCrypt.gensalt());
	}

	// converts a String to Date format
	public Date convertStringToDate(String stringDate) throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date;

		try {

			date = formatter.parse(stringDate);

		} catch (ParseException e) {

			e.printStackTrace();
			throw e;

		}
		return date;
	}

	// checks if the update date is equal or before the target date
	public boolean checkTargetDate(Date targetDate, Date updatedDate) {

		if (updatedDate.equals(targetDate) || (updatedDate.before(targetDate))) {

			return true;
		}
		return false;
	}
}
