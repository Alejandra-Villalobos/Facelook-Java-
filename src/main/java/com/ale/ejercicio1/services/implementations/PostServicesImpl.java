package com.ale.ejercicio1.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.ale.ejercicio1.models.entities.Post;
import com.ale.ejercicio1.services.PostServices;

@Service
public class PostServicesImpl implements PostServices{
private static List<Post> posts = new ArrayList<>();
	
	static {
		posts.add(new Post("post", "example post", "root"));
	}

	@Override
	public void savePost(Post post, String currentUser) {
		Post newPost = new Post(post.getTitle(), post.getPost(), currentUser);
		posts = Stream.concat(Stream.of(newPost), posts.stream()).collect(Collectors.toList());
		
	}

	@Override
	public List<Post> finAllPosts() {
		return posts;
	}
	

}
