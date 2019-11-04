package ar.com.ada.api.challenge.simulacrochallenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ar.com.ada.api.challenge.simulacrochallenge.services.EmpleadoService;

/**
 * EmpleadoController
 */
@RestController
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    /*
     * @GetMapping("/empleados/{id}")find all public EmpleadoResponse
     * GetInfoEmpleado(@PathVariable int id) { EmpleadoResponse e = new
     * EmpleadoResponse(); e.empleadoId = id; e.nombre =
     * empleadoService.buscarPorId(id).nombre; e.edad =
     * empleadoService.buscarPorId(id).edad; e.estado =
     * empleadoService.buscarPorId(id).estado; e.fechaAlta =
     * empleadoService.buscarPorId(id).fechaAlta; e.fechaBaja =
     * empleadoService.buscarPorId(id).fechaBaja; e.sueldo =
     * empleadoService.buscarPorId(id).sueldo; return e; }
     */
    // find by id
   /* @GetMapping("/empleados/{id}/categorias")
    public EmpleadoResponse GetInfoEmpleadoCategoria(@PathVariable int id) {
        EmpleadoResponse e = new EmpleadoResponse();
        e.empleadoId = id;
        e.nombre = empleadoService.buscarPorId(id).getNombre();
        e.edad = empleadoService.buscarPorId(id).getEdad();
        e.estado = empleadoService.buscarPorId(id).getEstado();
        e.fechaAlta = empleadoService.buscarPorId(id).getFechaAlta();
        e.fechaBaja = empleadoService.buscarPorId(id).getFechaBaja();
        e.sueldo = empleadoService.buscarPorId(id).getSueldo();
        e.categoria = empleadoService.buscarPorId(id).getCategoria();
        return e;
    }*/
}