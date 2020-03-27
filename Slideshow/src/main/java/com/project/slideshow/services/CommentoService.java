package com.project.slideshow.services;

import java.util.List;

import com.project.slideshow.models.Commento;

public interface CommentoService {
	public List<Commento> getAllCommenti();
	public Commento getCommento(int id);
	public void addCommento(Commento commento);
	public void updateCommento(Commento commento);
	public void deleteCommento(int id);
}
