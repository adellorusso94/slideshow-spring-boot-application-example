package com.project.slideshow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.slideshow.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer>{
	
}
