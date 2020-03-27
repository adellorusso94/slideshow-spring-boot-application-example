package com.project.slideshow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.slideshow.models.Commento;

@Repository
public interface CommentoRepository extends JpaRepository<Commento,Integer>{
	
}
