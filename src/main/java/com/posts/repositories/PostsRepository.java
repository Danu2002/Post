package com.posts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.posts.entities.Posts;

public interface PostsRepository extends JpaRepository<Posts,Long> {

}
