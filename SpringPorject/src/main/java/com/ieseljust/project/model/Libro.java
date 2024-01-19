package com.ieseljust.project.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Libro")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLibro;

	@Column(name = "tipus")
	private String tipus;

	@Column(name = "titol")
	private String titol;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idAutor")
	private Autor elAutor;

	public Libro() {
	}

	public Libro(int idLibro, String tipus, String titol, Autor elAutor) {
		super();
		this.idLibro = idLibro;
		this.tipus = tipus;
		this.titol = titol;
		this.elAutor = elAutor;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}

	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public Autor getElAutor() {
		return elAutor;
	}

	public void setElAutor(Autor elAutor) {
		this.elAutor = elAutor;
	}

}
