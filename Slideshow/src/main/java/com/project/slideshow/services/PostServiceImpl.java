package com.project.slideshow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.slideshow.models.Post;
import com.project.slideshow.repositories.PostRepository;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public List<Post> getAllPost() {
		return postRepository.findAll();
	}

	@Override
	public Post getPost(int id) {
		return postRepository.findById(id).get();
	}

	@Override
	public void addPost(Post post) {
		postRepository.save(post);
	}

	@Override
	public void updatePost(Post post) {
		postRepository.save(post);
	}

	@Override
	public void deletePost(int id) {
		postRepository.deleteById(id);
	}
	
}
