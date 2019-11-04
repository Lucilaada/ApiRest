package ar.com.ada.api.fiflix.fiflix.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.fiflix.fiflix.entities.Usuario;

/**
 * PeliculaRepository
 */
@Repository
public interface PeliculaRepository extends MongoRepository<Usuario, Integer> {

}