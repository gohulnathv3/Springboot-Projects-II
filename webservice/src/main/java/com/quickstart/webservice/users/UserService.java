package com.quickstart.webservice.users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	private List<User> users = new ArrayList<>(Arrays.asList(
			new User("Gohul", "Nath", "Madurai"),
			new User("Amit", "Kumar", "Pune"),
			new User("Helen", "Chris", "Bangalore")
			));
	public List<User> getAllUsers(){
		return users;
	}
	public User getUserbyFirstName(String firstName) {
		return users.stream().filter(t -> t.getFirstName().equals(firstName)).findFirst().get();
	}
	public void addUser(User user) {
		users.add(user);
		
	}
	public void updateUser(String firstName, User user) {
		for (int i=0; i<users.size();i++) {
			User u = users.get(i);
			if (u.getFirstName().equals(firstName)) {
				users.set(i,user);
				return;
				
			}
		}
		
	}
	public void deleteTopic(String firstName) {
		users.removeIf(u -> u.getFirstName().equals(firstName));
		
	}
			

}
