package com.ale.ejercicio1.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.ale.ejercicio1.models.entities.User;
import com.ale.ejercicio1.services.UserServices;

@Service
public class UserServicesImpl implements UserServices{
	private static List<User> users = new ArrayList<>();
	static {
		users.add(new User("root", "12345", null));
	}
	@Override
	public void saveUser(User user) {
		User newUser = new User(user.getUsername(), user.getPassword(), null);
		users = Stream.concat(Stream.of(newUser), users.stream()).collect(Collectors.toList());
		
	}
	@Override
	public boolean checkUser(String user, String pass) {
		if (users.stream().filter(u ->
			(u.getUsername().equals(user) && u.getPassword().equals(pass))
		) != null) return true;
				return false;
	}
	

}
