package com.demo.persistence.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDemoData {
	
	static public User joanDoe() {
		User user = new User();
		user.setEmail("joandoe@gmail.com");
		user.setFirstName("Joan");
		user.setLastName("Doe");
		return user;
	}

	static public User johnDoe() {
		User user = new User();
		user.setEmail("johndoe@gmail.com");
		user.setFirstName("John");
		user.setLastName("Doe");
		return user;
	}

	static public User juanPerez() {
		User user = new User();
		user.setEmail("juanperez@gmail.com");
		user.setFirstName("Juan");
		user.setLastName("Perez");
		return user;
	}
	
	static public List<User> allData() {
		List<User> users = new ArrayList<User>();
		Collections.addAll(users, joanDoe(), johnDoe(), juanPerez());
		return users;
	}
}
