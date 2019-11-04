package ar.com.ada.api.fiflix.fiflix.entities;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Pelicula
 */
@Document(collection = "Peliculas")
public class Pelicula extends Contenido {

    public boolean ganoOscar;

}