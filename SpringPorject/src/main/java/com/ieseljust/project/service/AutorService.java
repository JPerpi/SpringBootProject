package com.ieseljust.project.service;

import java.util.List;

import com.ieseljust.project.DTO.AutorDTO;


public interface AutorService {

	void saveAutor(AutorDTO autorDTO);
	AutorDTO getAutorById(Integer id);
	List<AutorDTO> listAllAutores();
	void deleteAutor(Integer id);
}
