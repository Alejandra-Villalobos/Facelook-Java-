package com.ale.ejercicio1.services;

import java.util.List;

import com.ale.ejercicio1.models.entities.Post;

public interface PostServices {
	//post, findall
	void savePost(Post post, String currentUser);
	List<Post> finAllPosts();
}
