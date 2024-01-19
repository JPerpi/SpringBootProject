package com.ieseljust.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ieseljust.project.DTO.AutorDTO;
import com.ieseljust.project.model.Autor;
import com.ieseljust.project.repository.AutorRepo;
@Service
public class AutorServiceImp implements AutorService {

	@Autowired
	private AutorRepo autorrepo;
	
	@Override
	public void saveAutor(AutorDTO autorDTO) {
		Autor autor =AutorDTO.convertToEntity(autorDTO);
		autorrepo.save(autor);
		
	}

	@Override
	public AutorDTO getAutorById(Integer id) {
		Optional<Autor> autor =autorrepo.findById(id);
		if(autor.isPresent()) {
			return AutorDTO.convertToDTO(autor.get());
		}else {
			return null;
		}
	}

	@Override
	public List<AutorDTO> listAllAutores() {
		List<Autor> lista =autorrepo.findAll();
		List<AutorDTO> listaResultado=new ArrayList<AutorDTO>();
		for(int i=0; i<lista.size();i++) {
			listaResultado.add(AutorDTO.convertToDTO(lista.get(i)));
		}
		return listaResultado;
	}

	@Override
	public void deleteAutor(Integer id) {
		autorrepo.deleteById(id);
		
	}

}
