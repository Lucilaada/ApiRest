package ar.com.ada.api.challenge.simulacrochallenge.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.api.challenge.simulacrochallenge.entities.Categoria;

/**
 * CategoriaRepository
 */
public interface CategoriaRepository extends JpaRepository<Categoria, String>{

    
}