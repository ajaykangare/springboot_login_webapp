package com.mindstix.webapp.service;





import org.springframework.data.mongodb.repository.MongoRepository;

import com.mindstix.webapp.model.User;

public interface UserServiceInterface extends MongoRepository<User, String> {

//	User findOne(User user);
	
	java.util.List<User> findAll();
	
	@SuppressWarnings("unchecked")
	User save(User user);

}
