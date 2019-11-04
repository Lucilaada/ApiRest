package ar.com.ada.api.challenge.simulacrochallenge.models.request;

import org.hibernate.type.DateType;

/**
 * EmpleadoRequest
 */
public class EmpleadoRequest {

    public String nombre;
    public String categoria;
    public Double sueldo;
    public int edad;
    public String estado;
    public DateType fechaAlta;
    public DateType fechaBaja;
    public int categoriaId;

}