package ar.com.ada.api.fiflix.fiflix.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.fiflix.fiflix.entities.Serie;
import ar.com.ada.api.fiflix.fiflix.repo.SerieRepository;

/**
 * SerieService
 */
@Service
public class SerieService {
    @Autowired
    SerieRepository repo;

    public void grabar(Serie serie) {
        repo.save(serie);
    }

    public Serie buscarPorId(ObjectId id) {
        return repo.findBy_id(id);
    }

    public Serie buscarPorNombre(String nombre) {
        return repo.findByNombre(nombre);
    }

    public List<Serie> getCatalogo() {
        return repo.findAll();
    }
}