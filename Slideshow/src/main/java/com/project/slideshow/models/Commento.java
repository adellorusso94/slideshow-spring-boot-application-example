package com.project.slideshow.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="commento")
public class Commento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_commento;
	private String testo;
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private Date data;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="utente", referencedColumnName="id_utente")
	private Utente autore;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="post", referencedColumnName="id_post")
	private Post post;

	public Commento() {
		
	}

	public Commento(int id_commento, String testo, Date data, Utente autore, Post post) {
		this.id_commento = id_commento;
		this.testo = testo;
		this.data = data;
		this.autore = autore;
		this.post = post;
	}

	public int getId_commento() {
		return id_commento;
	}

	public void setId_commento(int id_commento) {
		this.id_commento = id_commento;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Utente getAutore() {
		return autore;
	}

	public void setAutore(Utente autore) {
		this.autore = autore;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
}