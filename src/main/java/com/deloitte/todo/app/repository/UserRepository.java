package com.deloitte.todo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.deloitte.todo.app.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserName(String userName);

}
