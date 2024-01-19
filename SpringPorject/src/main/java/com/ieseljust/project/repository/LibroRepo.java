package com.ieseljust.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ieseljust.project.model.Libro;

@Repository
@Transactional
public interface LibroRepo extends JpaRepository<Libro, Integer> {

}
