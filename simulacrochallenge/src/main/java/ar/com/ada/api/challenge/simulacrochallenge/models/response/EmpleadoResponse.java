package ar.com.ada.api.challenge.simulacrochallenge.models.response;

import org.hibernate.type.DateType;

/**
 * EmpleadoResponse
 */
public class EmpleadoResponse {
    public boolean isOk;
    public String message;
    public Integer empleadoId;
    public String nombre;
    public String categoria;
    public Double sueldo;
    public int edad;
    public String estado;
    public DateType fechaAlta;
    public DateType fechaBaja;
    
}