package com.ieseljust.project.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Autor")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAutor;

	@Column(name = "nacionalitat")
	private String nacionalitat;

	@Column(name = "nom")
	private String nom;

	@OneToMany(mappedBy = "elAutor", cascade = CascadeType.PERSIST)
	private Set<Libro> elsLlibres;

	public Autor() {
	}

	public Autor(int idAutor, String nacionalitat, String nom, Set<Libro> elsLlibres) {
		super();
		this.idAutor = idAutor;
		this.nacionalitat = nacionalitat;
		this.nom = nom;
		this.elsLlibres = elsLlibres;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public String getNacionalitat() {
		return nacionalitat;
	}

	public void setNacionalitat(String nacionalitat) {
		this.nacionalitat = nacionalitat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Libro> getElsLlibres() {
		return elsLlibres;
	}

	public void setElsLlibres(Set<Libro> elsLlibres) {
		this.elsLlibres = elsLlibres;
	}

}