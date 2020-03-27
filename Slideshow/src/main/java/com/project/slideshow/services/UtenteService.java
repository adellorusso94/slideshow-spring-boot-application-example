package com.project.slideshow.services;

import java.util.Date;
import java.util.List;

import com.project.slideshow.models.Utente;

public interface UtenteService {
	public List<Utente> getAllUtenti();
	public Utente getUtente(int id);
	public int addUtente(Utente utente);
	public int updateUtente(String username, String password,String nome,String cognome,Date data, int id);
	public void deleteUtente(int id);
	public boolean validate(Utente utente);
	public Utente getUtenteByUsername(String username);
}
