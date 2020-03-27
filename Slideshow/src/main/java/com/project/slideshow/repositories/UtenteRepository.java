package com.project.slideshow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.slideshow.models.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente,Integer>{
	public Utente findByUsernameIgnoreCase(String username);
	public Utente findByUsernameAndPassword(String username,String password);
	
}
