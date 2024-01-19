package com.ieseljust.project.service;

import java.util.List;

import com.ieseljust.project.DTO.LibroDTO;

public interface LibroService {

	void saveLibro(LibroDTO LibroDTO);
	LibroDTO getLibroById(Integer id);
	List<LibroDTO> listAllLibros();
	void deleteLibro(Integer id);
}
