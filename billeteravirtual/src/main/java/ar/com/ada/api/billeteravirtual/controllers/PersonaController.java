package ar.com.ada.api.billeteravirtual.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.billeteravirtual.entities.Persona;
import ar.com.ada.api.billeteravirtual.services.PersonaService;

/**
 * PersonaController
 */
@RestController
public class PersonaController {

    @Autowired
    PersonaService personaService;

   /* @GetMapping("/personas")
    public List<Persona> GetPersonas() {
        List<Persona> lp = personaService.getPersonas();

        return lp;
    }*/
    @GetMapping("/personas")
    public List<Persona> getPersonas(Authentication authentication, Principal principal, @RequestParam(value = "nombre", required = false) String nombre) {
        List<Persona> lp;

        if (nombre == null) {
            lp = personaService.buscarPersonasOrdenadoPorNombre();
        } else {
            lp = personaService.buscarTodosPorNombre(nombre);
        }

        return lp;
    }

    @GetMapping("/personas/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable int id) {
        Persona p = personaService.buscarPorId(id);

        if (p == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(p);
    }
}