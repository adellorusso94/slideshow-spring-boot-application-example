package com.project.slideshow.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.slideshow.models.Commento;
import com.project.slideshow.services.CommentoServiceImpl;
import com.project.slideshow.services.PostServiceImpl;
import com.project.slideshow.services.UtenteServiceImpl;

@RestController
public class CommentoController {

	@Autowired
	private CommentoServiceImpl commentoService;
	
	@Autowired
	private UtenteServiceImpl utenteService;
	
	@Autowired
	private PostServiceImpl postService;

	// Create
	@PostMapping("/home/post/{id1}/commenti/crea")
	public ModelAndView addCommento(@PathVariable int id1, @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss") Date data, @RequestParam String testo, @RequestParam int id_utente) {
		Commento commento = new Commento();
		commento.setData(data);
		commento.setTesto(testo);
		commento.setAutore(utenteService.getUtente(id_utente));
		commento.setPost(postService.getPost(id1));
		commentoService.addCommento(commento);
		return new ModelAndView("redirect:/home/post/{id1}");
	}

	// Update
	@PostMapping("/home/post/{id1}/commenti/{id2}/modifica")
	public ModelAndView updateCommento(@PathVariable int id1, @PathVariable int id2, @RequestParam String testo) {
		Commento commento = commentoService.getCommento(id2);
		commento.setTesto(testo);
		commentoService.updateCommento(commento);
		return new ModelAndView("redirect:/home/post/{id1}");
	}

	// Delete
	@GetMapping("/home/post/{id1}/commenti/{id2}/cancella")
	public ModelAndView deleteCommento(@PathVariable int id1, @PathVariable int id2) {
		commentoService.deleteCommento(id2);
		return new ModelAndView("redirect:/home/post/{id1}");
	}
}
