package ar.com.ada.api.challenge.simulacrochallenge.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.challenge.simulacrochallenge.entities.Categoria;
import ar.com.ada.api.challenge.simulacrochallenge.services.CategoriaService;

/**
 * CategoriaController
 */
@RestController
 public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;
    
    @GetMapping("/categorias")
    public List<Categoria> GetCategorias() {
        List<Categoria> lc = categoriaService.getCategorias();
        return lc;
    }
}