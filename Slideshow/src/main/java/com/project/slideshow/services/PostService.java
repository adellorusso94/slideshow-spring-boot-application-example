package com.project.slideshow.services;

import java.util.List;

import com.project.slideshow.models.Post;

public interface PostService {
	public List<Post> getAllPost();
	public Post getPost(int id);
	public void addPost(Post post);
	public void updatePost(Post post);
	public void deletePost(int id);
}
