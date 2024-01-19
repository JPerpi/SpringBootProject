package com.ieseljust.project.DTO;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.ieseljust.project.model.Autor;
import com.ieseljust.project.model.Libro;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class AutorDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAutor;

	@Column(name = "nacionalitat")
	private String nacionalitat;

	@Column(name = "nom")
	private String nom;

	@Column(name = "")
	private List<LibroDTO> libros;

	public List<LibroDTO> getLibros() {
		return libros;
	}

	public void setLibros(List<LibroDTO> libros) {
		this.libros = libros;
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

	public static AutorDTO convertToDTO(Autor autor) {
		AutorDTO aDTO = new AutorDTO();
		aDTO.setIdAutor(autor.getIdAutor());
		aDTO.setNacionalitat(autor.getNacionalitat());
		aDTO.setNom(autor.getNom());

		List<LibroDTO> libroDTOList = autor.getElsLlibres().stream().map(LibroDTO::convertToDTO)
				.collect(Collectors.toList());

		aDTO.setLibros(libroDTOList);

		return aDTO;

	}

	public static Autor convertToEntity(AutorDTO aDTO) {
		Autor autor = new Autor();
		autor.setIdAutor(aDTO.getIdAutor());
		autor.setNacionalitat(aDTO.getNacionalitat());
		autor.setNom(aDTO.getNom());

		if (aDTO.getLibros() != null) {
			Set<Libro> libros = aDTO.getLibros().stream().map(LibroDTO::convertToEntity).collect(Collectors.toSet());

			autor.setElsLlibres(libros);
		}

		return autor;
	}

}
