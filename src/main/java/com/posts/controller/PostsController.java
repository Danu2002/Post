package com.posts.controller;

import java.io.IOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.posts.entities.Posts;
import com.posts.services.PostsService;

@Controller
public class PostsController {
	
		
		@Autowired
		PostsService service;
		
		@PostMapping("/createPost")
		public String createPost(@RequestParam("caption") String caption,
								@RequestParam("photo") MultipartFile photo, Model model) {
			
			Posts post = new Posts();
			post.setCaption(caption);
			try {
				post.setPhoto(photo.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			service.createPost(post);
			List<Posts> allPost=service.fetchAllPost();
			model.addAttribute("allPost",allPost);
			return "index";
		}
		
		@GetMapping("/likePost")
		public  String likePost(@RequestParam Long id,Model model) {
			Posts post = service.getPost(id);
			post.setLikes(post.getLikes()+1);
			service.updatePost(post);
			
			List<Posts> allPost=service.fetchAllPost();
			model.addAttribute("allPost",allPost);
			return "index";
		}
		
		@GetMapping("/post")
		public String post(Model model) {
			
			List<Posts> allPost=service.fetchAllPost();
			model.addAttribute("allPost", allPost);
			return "index";
					
		}
}
