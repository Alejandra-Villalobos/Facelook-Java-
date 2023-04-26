package com.ale.ejercicio1.services;

import com.ale.ejercicio1.models.entities.User;

public interface UserServices {
	//signin, findOnde
	void saveUser(User user);
	boolean checkUser(String user, String pass);
}
