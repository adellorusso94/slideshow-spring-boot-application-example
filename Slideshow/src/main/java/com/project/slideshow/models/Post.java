package com.project.slideshow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="post")
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_post;
	private String descrizione;
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private Date data;
	@Lob @Basic(fetch = FetchType.LAZY)
	@Column(length=20000000)
	private byte[] immagine;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Commento> commenti;
	
	@ManyToOne
	@JoinColumn(name="autore", referencedColumnName="id_utente")
	private Utente autore;
	
	public Post() {
		
	}

	public Post(int id_post, String descrizione, Date data, byte[] immagine, List<Commento> commenti, Utente autore) {
		this.id_post = id_post;
		this.descrizione = descrizione;
		this.data = data;
		this.immagine = immagine;
		this.commenti = commenti;
		this.autore = autore;
	}

	public byte[] getImmagine() {
		return immagine;
	}

	public void setImmagine(byte[] immagine) {
		this.immagine = immagine;
	}


	public List<Commento> getCommenti() {
		return commenti;
	}


	public void setCommenti(List<Commento> commenti) {
		this.commenti = commenti;
	}


	public Utente getAutore() {
		return autore;
	}


	public void setAutore(Utente autore) {
		this.autore = autore;
	}


	public int getId_post() {
		return id_post;
	}

	public void setId_post(int id_post) {
		this.id_post = id_post;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}