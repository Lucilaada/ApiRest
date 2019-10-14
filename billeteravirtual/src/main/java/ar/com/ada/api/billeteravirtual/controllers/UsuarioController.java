package ar.com.ada.api.billeteravirtual.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.billeteravirtual.entities.Usuario;
import ar.com.ada.api.billeteravirtual.services.UsuarioService;

/**
 * UsuarioController
 */
@RestController
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public List<Usuario> GetUsuarios() {
        List<Usuario> lu = usuarioService.getUsuarios();

        return lu;
    }

    @GetMapping("/usuarios/{id}")
    public Usuario GetUsuarioById(@PathVariable int id) {
        Usuario p = usuarioService.buscarPorId(id);

        return p;
    }
    @GetMapping("/usuarios/{email}")
    public Usuario GetUsuarioByEmail(@PathVariable String userEmail) {
        Usuario p = usuarioService.buscarPorEmail(userEmail);

        return p;
    }


}