package ar.com.ada.api.challenge.simulacrochallenge.entities;

import java.util.*;

import javax.persistence.*;

import org.hibernate.type.DateType;

/**
 * Empleado
 */
@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @Column(name = "empleado_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empleadoId;

    public String nombre;
    public Integer edad;
    public Double sueldo;
    public String estado;
    @Column(name = "fecha_alta")
    public DateType fechaAlta;
    @Column(name = "fecha_baja")
    public DateType fechaBaja;
    public String categoria;
    public List<Categoria> categorias = new ArrayList<Categoria>();

    public Integer getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public DateType getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(DateType fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public DateType getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(DateType fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public Empleado() {
    }

    public void setEmpleadoId(Categoria categoria2) {
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Empleado(Integer empleadoId, String nombre, Integer edad, Double sueldo, String estado, DateType fechaAlta,
            DateType fechaBaja, String categoria) {
        this.empleadoId = empleadoId;
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
        this.estado = estado;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.categoria = categoria;
    }

    public void agregarCategoria(Categoria categoria) {
        categoria.setCategoriaId(categoria.getCategoriaId());
        categorias.add(categoria);
    }

}