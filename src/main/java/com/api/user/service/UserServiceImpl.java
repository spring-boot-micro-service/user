package com.api.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.user.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	// fake user list
	
	List<User> list = List.of(
			new User(1234L, "David", "123456"),
            new User(5678L, "James", "43534345"),
            new User(9012L, "Max", "456")
			);

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return list.stream().filter(user -> user.getUserId().equals(id)).findAny().orElse(null);
	}

}
