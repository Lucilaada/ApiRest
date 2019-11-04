package ar.com.ada.api.challenge.simulacrochallenge.services;

import java.util.Optional;

import org.hibernate.type.DateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.challenge.simulacrochallenge.entities.Categoria;
import ar.com.ada.api.challenge.simulacrochallenge.entities.Empleado;
import ar.com.ada.api.challenge.simulacrochallenge.repo.EmpleadoRepository;

/**
 * empleadoService
 */
@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;

    public Empleado buscarPorId(int id) {
        Optional<Empleado> e = empleadoRepository.findById(id);
        if (e.isPresent())
            return e.get();
        return null;
    }

    /*
     * public int altaEmpleado(String nombre, String categoria, String estado,
     * Integer edad, Double sueldo, DateType fechaAlta, DateType fechaBaja) {
     * Empleado e = new Empleado(); e.setNombre(nombre); e.setEstado(estado);
     * e.setEdad(edad); e.setSueldo(sueldo); e.setFechaAlta(fechaAlta);
     * e.setFechaBaja(fechaBaja); e.agregarEmpleado(e);
     * 
     * return e.getEmpleadoId(); }
     */
    public int altaEmpleado(String nombre, String categoria, String estado, int edad, Double sueldo,
            DateType fechaAlta, DateType fechaBaja) {
        Empleado e = new Empleado();
        e.setNombre(nombre);
        e.setCategoria(categoria);
        e.setEdad(edad);
        e.setEstado(estado);
        e.setSueldo(sueldo);
        e.setFechaAlta(fechaAlta);
        e.setFechaBaja(fechaBaja);
        empleadoRepository.save(e);
        return e.getEmpleadoId();
    }
}