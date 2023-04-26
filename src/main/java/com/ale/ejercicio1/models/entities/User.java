package com.ale.ejercicio1.models.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	private String username;
	private String password;
	private List<Post> posts;
}
