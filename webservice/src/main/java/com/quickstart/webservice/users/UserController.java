package com.quickstart.webservice.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	public UserService userService;
	
	@RequestMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@RequestMapping("/users/{firstName}")
	public User getUser(@PathVariable String firstName) {
		return userService.getUserbyFirstName(firstName);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	@RequestMapping(method = RequestMethod.PUT, value="/users/{firstName}")
	public void updateUser(@RequestBody User user, @PathVariable String firstName) {
		userService.updateUser(firstName,user);
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{firstName}")
	public void deleteTopic(@PathVariable String firstName) {
		userService.deleteTopic(firstName);
	}

}
