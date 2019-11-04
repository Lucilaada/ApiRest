package ar.com.ada.api.challenge.simulacrochallenge.entities;

import java.util.*;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Categoria
 */

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @Column(name = "categoria_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoriaId;
    public String nombre;
    @Column(name = "sueldo_base")
    public Double sueldoBase;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Empleado> empleados = new ArrayList<Empleado>();

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(Double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public Categoria(Integer categoriaId, List<Empleado> empleados, String nombre, Double sueldoBase) {
        this.categoriaId = categoriaId;
        this.empleados = empleados;
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
    }

    public Categoria() {
    }

    public void agregarEmpleado(Empleado empleado) {
        empleado.setEmpleadoId(empleado.getEmpleadoId());
        empleados.add(empleado);
    }

}