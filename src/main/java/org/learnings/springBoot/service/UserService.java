package org.learnings.springBoot.service;

import org.learnings.springBoot.dto.User;
import org.learnings.springBoot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public void signUp(User user) {
		userRepository.save(user);
	}
}
