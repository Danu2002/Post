package com.posts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posts.entities.Posts;
import com.posts.repositories.PostsRepository;

@Service
public class PostsServiceImplementation implements PostsService {
	@Autowired
	PostsRepository repo;
	
	public void createPost(Posts post) {
		repo.save(post);	
	}

	@Override
	public List<Posts> fetchAllPost() {
		
		return repo.findAll();
	}

	@Override
	public Posts getPost(Long id) {
		
		return repo.findById(id).get();
	}

	@Override
	public void updatePost(Posts post) {
		repo.save(post);
		
	}


}
