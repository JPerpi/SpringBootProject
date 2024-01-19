package com.ieseljust.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ieseljust.project.SpringPorjectApplication;
import com.ieseljust.project.DTO.AutorDTO;
import com.ieseljust.project.DTO.LibroDTO;
import com.ieseljust.project.model.Autor;
import com.ieseljust.project.service.AutorService;
import com.ieseljust.project.service.LibroService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class ControTotal {
	
	private static final Logger myLog=LoggerFactory.getLogger(SpringPorjectApplication.class);
		
	@Autowired
	private AutorService autorservice;
	
	@Autowired
	private LibroService libroservice;
	
	@Autowired
	private HttpServletRequest context;
	
	@Value("${app.name}")
	private String appName;
	
	@Value("${developer.name}")
	private String devName;
	
	
	@GetMapping("/")
	public String index() {
		String res="Hello!!!\n";
		res+="BIenvenid@ al proyecto "+appName+"\n";
		return res;		
		
	}
	
	@GetMapping("/about")
	public String about() {
		String res="Sobre el proyecto: ";
		res+="Desarrollado por : "+devName+"\n";
		res+="Es un proyecto básico para aprender el funcionamiento de SpringBoot";
		return res;		
		
	}
	

	@GetMapping("/autores")
	public List<AutorDTO>listAutores(){
		myLog.info(context.getMethod() + " from " + context.getRemoteHost());
		List<AutorDTO> losAutores=autorservice.listAllAutores();
		return losAutores;
	}

	@GetMapping("/autores/{idAutor}")
	public AutorDTO showAutorById(@PathVariable int idAutor) {
		myLog.info(context.getMethod() + " from " + context.getRemoteHost());
		AutorDTO elAutor=autorservice.getAutorById(idAutor);
		return elAutor;
	}
	

	@PostMapping("/autores")
	public void addAutor(@RequestBody AutorDTO nAutor) {
	    myLog.info(context.getMethod() + context.getRequestURI());
	    autorservice.saveAutor(nAutor);
	}

	@PutMapping("/autores")
	public void updateCliente(@RequestBody AutorDTO updCliente) {
	    myLog.info(context.getMethod() + context.getRequestURI());

	    AutorDTO elAutor = autorservice.getAutorById(updCliente.getIdAutor());

	    // Actualizar elAutor con los datos de updCliente
	    elAutor.setNacionalitat(updCliente.getNacionalitat());
	    elAutor.setNom(updCliente.getNom());

	    // Guardar elAutor actualizado
	    autorservice.saveAutor(elAutor);
	}

	@GetMapping("/libros")
	public List<LibroDTO> listLibros() {
	    myLog.info(context.getMethod() + " from " + context.getRemoteHost());
	    List<LibroDTO> losLibros = libroservice.listAllLibros();
	    return losLibros;
	}

	@GetMapping("/libros/{idLibro}")
	public LibroDTO showLibroById(@PathVariable int idLibro) {
	    myLog.info(context.getMethod() + " from " + context.getRemoteHost());
	    LibroDTO elLibro = libroservice.getLibroById(idLibro);
	    return elLibro;
	}

	@PostMapping("/libros")
	public void addLibro(@RequestBody LibroDTO nLibro) {
	    myLog.info(context.getMethod() + context.getRequestURI());
	    libroservice.saveLibro(nLibro);
	}

	@PutMapping("/libros")
	public void updateLibro(@RequestBody LibroDTO updLibro) {
	    myLog.info(context.getMethod() + context.getRequestURI());

	    LibroDTO elLibro = libroservice.getLibroById(updLibro.getIdLibro());

	    // Actualizar elLibro con los datos de updLibro
	    elLibro.setTipus(updLibro.getTipus());
	    elLibro.setTitol(updLibro.getTitol());

	    // Guardar elLibro actualizado
	    libroservice.saveLibro(elLibro);
	}
	@PostMapping("/autores/libros")
	public void addAutorLibro(@RequestBody AutorDTO nAutor) {
		myLog.info(context.getMethod() + context.getRequestURI());

	    // Guardar el autor y obtener el nuevo autor con su ID asignado
	    autorservice.saveAutor(nAutor);

	    // Verificar si hay información sobre el libro en el DTO del autor
	    if (nAutor.getLibros() != null && !nAutor.getLibros().isEmpty()) {
	        // Asignar el autor al libro y guardar el libro
	        nAutor.getLibros().forEach(libroDTO -> {
	            libroDTO.setAutor(nAutor);
	            libroservice.saveLibro(libroDTO);
	        });
	    }
	}
	
}
