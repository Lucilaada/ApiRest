package ar.com.ada.api.challenge.simulacrochallenge.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.challenge.simulacrochallenge.entities.Categoria;
import ar.com.ada.api.challenge.simulacrochallenge.repo.CategoriaRepository;

/**
 * CategoriaService
 */
@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Categoria> getCategorias() {

        return categoriaRepository.findAll();
    }

    public int crearCategoria(String nombre, Double sueldoBase) {
        Categoria c = new Categoria();
        c.setNombre(nombre);
        c.setSueldoBase(sueldoBase);
        categoriaRepository.save(c);

        return c.getCategoriaId();
    }

    public Categoria save(Categoria c){
        return categoriaRepository.save(c);
    }

}