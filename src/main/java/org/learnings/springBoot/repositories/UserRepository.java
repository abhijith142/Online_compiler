package org.learnings.springBoot.repositories;

import org.learnings.springBoot.dto.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Integer>{
	public User findByName(String name);
}
