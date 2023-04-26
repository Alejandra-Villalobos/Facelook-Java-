package com.ale.ejercicio1.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Post {
	private String title;
	private String post;
	private String author;
}
