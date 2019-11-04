package ar.com.ada.api.challenge.simulacrochallenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.challenge.simulacrochallenge.models.request.CategoriaRequest;
import ar.com.ada.api.challenge.simulacrochallenge.models.request.EmpleadoRequest;
import ar.com.ada.api.challenge.simulacrochallenge.models.response.CategoriaResponse;
import ar.com.ada.api.challenge.simulacrochallenge.models.response.EmpleadoResponse;
import ar.com.ada.api.challenge.simulacrochallenge.services.CategoriaService;
import ar.com.ada.api.challenge.simulacrochallenge.services.EmpleadoService;

/**
 * AuthController
 */
@RestController
public class AuthController {
    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    CategoriaService categoriaService;

    @PostMapping("/empleado")
    public EmpleadoResponse postRegisterEmpleado(@RequestBody EmpleadoRequest req) throws Exception {
        EmpleadoResponse e = new EmpleadoResponse();
        empleadoService.altaEmpleado(req.nombre, req.categoria, req.estado, req.edad, req.sueldo, req.fechaAlta,
                req.fechaBaja);
        e.isOk = true;
        e.message = "Empleado creado con exito.";
        return e;
    }

    @PostMapping("/categoria")
    public CategoriaResponse postRegisterCategoria(@RequestBody CategoriaRequest req) {
        CategoriaResponse r = new CategoriaResponse();
        categoriaService.crearCategoria(req.nombre, req.sueldoBase);
        r.isOk = true;
        r.message = "Categoria registrada con exito.";
        return r;
    }
}