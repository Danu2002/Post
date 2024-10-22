package com.posts.services;

import java.util.List;

import com.posts.entities.Posts;

public interface PostsService {
	void createPost(Posts post);

	List<Posts> fetchAllPost();	

	Posts getPost(Long id);

	void updatePost(Posts post);
}
