package com.ale.ejercicio1.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ale.ejercicio1.models.dtos.savePostDTO;
import com.ale.ejercicio1.models.dtos.saveUserDTO;
import com.ale.ejercicio1.models.entities.Post;
import com.ale.ejercicio1.models.entities.User;
import com.ale.ejercicio1.services.PostServices;
import com.ale.ejercicio1.services.UserServices;
import com.ale.ejercicio1.utils.RequestErrorHandler;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/facelook")
public class FacelookControllers {
	
	@Autowired
	private RequestErrorHandler errorHandler;
	
	@Autowired
	private UserServices userService;
	
	@Autowired
	private PostServices postService;
	
	private String currentUsername;
	
	
	@GetMapping("/")
	public String getMainPage() {
		return "main";
	}
	
	@GetMapping("/signin")
	public String getSignInPage() {
		return "signin";
	}
	
	@GetMapping("/login")
	public String getLogInPage() {
		return "login";
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute @Valid saveUserDTO userInfo, BindingResult validations,
			Model model) {
		if(validations.hasErrors() || !userInfo.getPassword().equals(userInfo.getConfirmPassword())) {
			System.out.println("Errors!");
			model.addAllAttributes(errorHandler.mapErrors(validations.getFieldErrors()));
			model.addAttribute("hasErrors", true);
			return "signin";
		}
		User newUser = new User(userInfo.getUsername(), userInfo.getPassword(), null);
		userService.saveUser(newUser);
		
		return "redirect:/facelook/login";
	}
	
	@RequestMapping(value = "/dashboard", method =RequestMethod.GET)
	public String getDashboard(Model model) {
		model.addAttribute("currentUsername", currentUsername);
		model.addAttribute("posts", postService.finAllPosts());
		return "dashboard";
	}
	
	@PostMapping("/check")
	public String chechLogin(@ModelAttribute User user) {
		System.out.println(user);
		if(userService.checkUser(user.getUsername(), user.getPassword())) {
			currentUsername = user.getUsername();
			return "redirect:/facelook/dashboard";
		}
		else return "redirect:/facelook/login";
	}

	
	@PostMapping("/dashboard/post")
	public String savePost(@ModelAttribute savePostDTO postInfo) {
		Post addPost = new Post(postInfo.getTitle(), postInfo.getPost(), currentUsername);
		postService.savePost(addPost, currentUsername);
		return "redirect:/facelook/dashboard";
	}
	
	@GetMapping("/dashboard/logout")
	public String logOut() {
		currentUsername = null;
		return "redirect:/facelook/";
	}
}
