package com.ieseljust.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ieseljust.project.DTO.AutorDTO;
import com.ieseljust.project.DTO.LibroDTO;
import com.ieseljust.project.model.Autor;
import com.ieseljust.project.model.Libro;
import com.ieseljust.project.repository.AutorRepo;
import com.ieseljust.project.repository.LibroRepo;
@Service
public class LibroServiceImp  implements LibroService {

	
	@Autowired
	private LibroRepo librorepo;
	
	@Override
	public void saveLibro(LibroDTO LibroDTO) {
		Libro libro =LibroDTO.convertToEntity(LibroDTO);
		librorepo.save(libro);
		
	}

	@Override
	public LibroDTO getLibroById(Integer id) {
		Optional<Libro> libro =librorepo.findById(id);
		if(libro.isPresent()) {
			return LibroDTO.convertToDTO(libro.get());
		}else {
			return null;
		}
	}

	@Override
	public List<LibroDTO> listAllLibros() {
		List<Libro> lista =librorepo.findAll();
		List<LibroDTO> listaResultado=new ArrayList<LibroDTO>();
		for(int i=0; i<lista.size();i++) {
			listaResultado.add(LibroDTO.convertToDTO(lista.get(i)));
		}
		return listaResultado;
	}

	@Override
	public void deleteLibro(Integer id) {
		librorepo.deleteById(id);
		
	}

}
