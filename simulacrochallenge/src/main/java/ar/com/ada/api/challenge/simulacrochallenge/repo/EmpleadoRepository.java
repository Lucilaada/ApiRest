package ar.com.ada.api.challenge.simulacrochallenge.repo;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.api.challenge.simulacrochallenge.entities.Empleado;

/**
 * EmpleadoRepository
 */
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{

    Optional<Empleado> findById(Integer id);

    List<Empleado> findAll();
}