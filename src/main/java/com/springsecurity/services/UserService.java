package com.springsecurity.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springsecurity.model.User;

@Service
public class UserService {
	List<User> list = new ArrayList<>();

	public UserService() {
		list.add(new User("abc", "xyz@gmail.com", "xyz"));
		list.add(new User("pqr", "pqr@gmail.com", "pqr"));
	}

	public List<User> getAll() {
		return this.list;
	}

	public User getByName(String username) {

		return this.list.stream().filter((user) -> 		user.getUsername().equals(username)).findAny().orElse(null);
	}

	public void addUser(User user) {
		list.add(user);
		System.out.println("user added ....." + user);
	}

	public void deleteUser(String username) {
		Optional<User> op = list.stream().filter((user) -> user.getUsername().equals(username)).findFirst();

		if (op.isPresent()) {
			list.remove(op.get());
		}

	}
}
