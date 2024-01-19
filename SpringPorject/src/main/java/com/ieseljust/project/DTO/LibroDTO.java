package com.ieseljust.project.DTO;

import com.ieseljust.project.model.Autor;
import com.ieseljust.project.model.Libro;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class LibroDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLibro;

	@Column(name = "tipus")
	private String tipus;

	@Column(name = "titol")
	private String titol;

	private AutorDTO autor;

	public AutorDTO getAutor() {
		return autor;
	}

	public void setAutor(AutorDTO autor) {
		this.autor = autor;
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

	public static LibroDTO convertToDTO(Libro libro) {
		LibroDTO lDTO = new LibroDTO();
		lDTO.setIdLibro(libro.getIdLibro());
		lDTO.setTipus(libro.getTipus());
		lDTO.setTitol(libro.getTitol());

		AutorDTO autorDTO = AutorDTO.convertToDTO(libro.getElAutor());
		lDTO.setAutor(autorDTO);

		return lDTO;

	}

	public static Libro convertToEntity(LibroDTO lDTO) {
		Libro libro = new Libro();
		libro.setIdLibro(lDTO.getIdLibro());
		libro.setTipus(lDTO.getTipus());
		libro.setTitol(lDTO.getTitol());

		if (lDTO.getAutor() != null) {
			Autor autor = AutorDTO.convertToEntity(lDTO.getAutor());
			libro.setElAutor(autor);
		}

		return libro;
	}
}
