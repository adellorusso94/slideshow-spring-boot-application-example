package com.project.slideshow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.slideshow.models.Commento;
import com.project.slideshow.repositories.CommentoRepository;

@Service
public class CommentoServiceImpl implements CommentoService{
	
	@Autowired
	private CommentoRepository commentoRepository;
	
	@Override
	public List<Commento> getAllCommenti() {
		return commentoRepository.findAll();
	}

	@Override
	public Commento getCommento(int id) {
		return commentoRepository.findById(id).get();
	}

	@Override
	public void addCommento(Commento commento) {
		commentoRepository.save(commento);
	}

	@Override
	public void updateCommento(Commento commento) {
		commentoRepository.save(commento);
	}

	@Override
	public void deleteCommento(int id) {
		commentoRepository.deleteById(id);
	}

}
