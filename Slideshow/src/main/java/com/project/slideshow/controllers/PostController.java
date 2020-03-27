package com.project.slideshow.controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.slideshow.models.Post;
import com.project.slideshow.services.PostServiceImpl;
import com.project.slideshow.services.UtenteServiceImpl;

@RestController
public class PostController {

	@Autowired
	private PostServiceImpl postService;

	@Autowired
	private UtenteServiceImpl utenteService;

	// Read
	@GetMapping("/home/post")
	public ModelAndView getAllPost(HttpServletRequest request,Authentication auth) {
		ModelAndView mav = new ModelAndView("post");
		int id_utente;
		try{
			 id_utente = (int) request.getSession(true).getAttribute("idUtente");
		}catch(NullPointerException e) {
			id_utente=utenteService.getUtenteByUsername(auth.getName()).getId_utente();
			request.getSession(true).setAttribute("idUtente",id_utente);

		}
		mav.addObject("id_utente", id_utente);
		List<Post> lista_post = postService.getAllPost();
		Collections.reverse(lista_post);
		mav.addObject("lista_post", lista_post);
		return mav;
	}

	@GetMapping("/home/post/{id}")
	public ModelAndView getPost(HttpServletRequest request, @PathVariable int id,Authentication auth) {
		ModelAndView mav = new ModelAndView("dettaglioPost");
		int id_utente;
		try{
			 id_utente = (int) request.getSession(true).getAttribute("idUtente");
		}catch(NullPointerException e) {
			id_utente=utenteService.getUtenteByUsername(auth.getName()).getId_utente();
			request.getSession(true).setAttribute("idUtente",id_utente);

		}		
		mav.addObject("id_utente", id_utente);
		String admin = utenteService.getUtente(id_utente).getAuthorities().get(0).toString();
		mav.addObject("admin", admin);
		Post post = postService.getPost(id);
		mav.addObject("post", post);
		return mav;
	}
	
	@GetMapping("/home/post/{id}/immagine")
	public void showImage(@PathVariable int id, HttpServletResponse response) throws IOException {
		Post post = postService.getPost(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	    response.getOutputStream().write(post.getImmagine());
	    response.getOutputStream().close();
	}

	// Create
	@PostMapping("/home/post/crea")
	public ModelAndView addPost(@RequestParam String descrizione,
			@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss") Date data,
			@RequestParam MultipartFile immagine, @RequestParam int id_utente) throws IOException {
		Post post = new Post();
		post.setDescrizione(descrizione);
		post.setData(data);
		post.setImmagine(immagine.getBytes());
		post.setAutore(utenteService.getUtente(id_utente));
		postService.addPost(post);
		return new ModelAndView("redirect:/home/post");
	}

	// Update
	@PostMapping("/home/post/{id}/modifica")
	public ModelAndView updatePost(@PathVariable int id, @RequestParam String descrizione,
			@RequestParam MultipartFile immagine) throws IOException {
		Post post = postService.getPost(id);
		post.setDescrizione(descrizione);
		post.setImmagine(immagine.getBytes());
		postService.updatePost(post);
		return new ModelAndView("redirect:/home/post/{id}");
	}

	// Delete
	@GetMapping("/home/post/{id}/cancella")
	public ModelAndView deletePost(@PathVariable int id) {
		postService.deletePost(id);
		return new ModelAndView("redirect:/home/post");
	}

}
