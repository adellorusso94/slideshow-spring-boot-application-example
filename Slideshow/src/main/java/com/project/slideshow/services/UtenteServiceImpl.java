package com.project.slideshow.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.slideshow.models.Utente;
import com.project.slideshow.repositories.UtenteRepository;

@Service
public class UtenteServiceImpl implements UtenteService, UserDetailsService {
	
	@Autowired
	private UtenteRepository utenteRepository;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public List<Utente> getAllUtenti() {
		return utenteRepository.findAll();
	}

	@Override
	public Utente getUtente(int id) {
		return utenteRepository.findById(id).get();
	}

	@Override
	public int addUtente(Utente utente) {
		Utente user = utenteRepository.findByUsernameIgnoreCase(utente.getUsername());
		if(user==null) {
			utenteRepository.save(utente);
			return 0;
		}else {
			return 1;
		}
		
	}


	@Override
	public int updateUtente(String username, String password,String nome,String cognome,Date data,  int id) {
		Utente utente=utenteRepository.getOne(id);
		utente.setNome(nome);
		utente.setCognome(cognome);
		utente.setData_nascita(data);
		if(password!="")
			utente.setPassword(password);
		if(username!="") {
			utente.setUsername(username);
		}else {
			utenteRepository.save(utente);
			return 2;
		}
		Utente user = utenteRepository.findByUsernameIgnoreCase(utente.getUsername());
		if(user==null) {
			utenteRepository.save(utente);
			return 0;
		}else {
			return 1;
		}
	}

	@Override
	public void deleteUtente(int id) {
		utenteRepository.deleteById(id);
	}
	
	@Override
	public boolean validate(Utente utente) {
	  UserDetails userDetails = loadUserByUsername(utente.getUsername());
	  UsernamePasswordAuthenticationToken token =
	            new UsernamePasswordAuthenticationToken(userDetails, utente.getPassword(), userDetails.getAuthorities());
		        authenticationManager.authenticate(token);
		        boolean result = token.isAuthenticated();
		        if (result){
		            SecurityContextHolder.getContext().setAuthentication(token);
		        }
		        return result;
	}	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utente utente= utenteRepository.findByUsernameIgnoreCase(username);
	        if (utente!=null){
	            return utente;
	        }else{
	            throw new UsernameNotFoundException(String.format("Username[%username] not found"));
	        }
	}

	@Override
	public Utente getUtenteByUsername(String username) {
		return utenteRepository.findByUsernameIgnoreCase(username);
	}
}
