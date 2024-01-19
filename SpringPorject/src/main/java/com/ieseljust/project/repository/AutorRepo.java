package com.ieseljust.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ieseljust.project.model.Autor;

@Repository
@Transactional
public interface AutorRepo extends JpaRepository<Autor, Integer>{

}
