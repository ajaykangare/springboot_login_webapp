package com.mindstix.webapp.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindstix.webapp.model.User;
import com.mindstix.webapp.service.UserServiceInterface;

@RestController
public class LoginController  {

	@Autowired
	private UserServiceInterface userserviceinterface;
	
/*	@PostMapping("/login")
	public String userLogin(@RequestBody User user) {
		User resultUser = userserviceinterface.findOne(user);
		if(resultUser.getPassword() == user.getPassword()) {
			return resultUser.getUserName();
		}
		else {
			return "Login Failed";
		}
	}
*/	
	@GetMapping("/allusers")
	public java.util.List<User> users() {
		return userserviceinterface.findAll();
	}
	
	@PostMapping("/register")
	public String  registerUser(@RequestBody User user) {
		userserviceinterface.save(user);
		return "User Added Successfully";
	}
}
