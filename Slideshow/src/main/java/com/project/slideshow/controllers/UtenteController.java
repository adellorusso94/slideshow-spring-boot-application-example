package com.project.slideshow.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.slideshow.models.Role;
import com.project.slideshow.models.Utente;
import com.project.slideshow.services.UtenteServiceImpl;

@RestController
public class UtenteController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UtenteServiceImpl utenteService;
	
	private static Utente utente1;
	
	public static Utente getUtente1() {
		return utente1;
	}

	@GetMapping("/")
   	public ModelAndView getLogin(HttpServletRequest request, HttpServletResponse response,
   			@RequestParam(value = "error", required = false) String error) {
		
		ModelAndView mav = new ModelAndView("index");
		if(error!=null) {
			mav.addObject("message", "Username e/o password errati!");
		}else {
			mav.addObject("message", "Benvenuto!");
		}
		mav.addObject("login", new Utente());
		return mav;
	}
	
	@PostMapping("/")
	public ModelAndView postLogin(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") Utente utente) {
		
		ModelAndView mav = null;
		boolean loginResult = utenteService.validate(utente);
		if (loginResult) {
			mav = new ModelAndView("redirect:/home", model);
			return mav;
		}else {
			mav = new ModelAndView("redirect:/?error=true");
			return mav;
		}
		
	}

	@GetMapping("/registrazione")
    public ModelAndView registrazione(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("registrazione");
	    mav.addObject("message", "Benvenuto!");
	    mav.addObject("registrazione", new Utente());
	    return mav;
	  }
    
    @PostMapping("/registrazione")
    public ModelAndView postRegistrazione(HttpServletRequest request, HttpServletResponse response, @RequestParam("roles") Role role, @ModelAttribute("registrazione") Utente utente) {
    	ModelAndView mav = null;
    	utente.setPassword(passwordEncoder.encode(utente.getPassword()));
    	utente.grantAuthority(role);
    	int res = utenteService.addUtente(utente);
    		if(res==1) {
        	mav = new ModelAndView("registrazione");
    	    mav.addObject("message","Username non disponibile");
    	}else{
    		mav=new ModelAndView("index");
    	    mav.addObject("message","Registrato!");
    	}
        return mav;
	  }

	@GetMapping("/home")
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response, Authentication auth) {
		ModelAndView mav = new ModelAndView("redirect:/home/post");
		utente1 = utenteService.getUtenteByUsername(auth.getName());
		request.getSession(true).setAttribute("idUtente", utente1.getId_utente());
		return mav;
	}
	
	
	@GetMapping("/profili/{id}")
	public ModelAndView getUtente(@PathVariable int id) {
		ModelAndView mav = new ModelAndView("profiloUtente");
		Utente utente=utenteService.getUtente(id);
		mav.addObject("utente",utente);
		return mav;
	}
	@GetMapping("/profili/{id}/modifica")
	public ModelAndView getModUtente(@PathVariable int id,HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("modificaProfilo");
		mav.addObject("mod",utente1);
		return mav;
	}
	// Update
	@PostMapping("/profili/{id}/modifica")
	public ModelAndView updateUtente(@PathVariable int id, @ModelAttribute("mod") Utente utente,HttpServletRequest request,
				HttpServletResponse response) throws IOException {
			int res;
			if (utente.getPassword()=="") {
				res=utenteService
				.updateUtente(utente.getUsername(),
				utente.getPassword(),utente.getNome(),utente.getCognome(),utente.getData_nascita(),id);
			}else {
				res=utenteService
				.updateUtente(utente.getUsername(),
				passwordEncoder.encode(utente.getPassword()),utente.getNome(),utente.getCognome(),utente.getData_nascita(),id);
			}
			
			ModelAndView mav = null;
			if(res==1) {
	        	mav = new ModelAndView("modificaProfilo");
	    	    mav.addObject("message","Username non disponibile");
	    	}else if(res==0){

	    		mav=new ModelAndView("modificaProfilo");
	    	    mav.addObject("res","Ok");
	    	}else {
	    		mav=new ModelAndView("redirect:/profili/{id}");
	    	}
			
			return mav;
		}

}
