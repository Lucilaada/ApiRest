package ar.com.ada.api.billeteravirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ar.com.ada.api.billeteravirtual.excepciones.PersonaEdadException;
import ar.com.ada.api.billeteravirtual.models.request.RegistrationRequest;
import ar.com.ada.api.billeteravirtual.models.response.RegistrationResponse;
import ar.com.ada.api.billeteravirtual.services.UsuarioService;

/**
 * AuthController
 */
@RestService
public class AuthController {

    /*
     * @Autowired UsuarioService usuarioService;
     * 
     * @PostMapping("auth/register") public RegistrationResponse
     * postRegisterUser(@RequestBody RegistrationRequest req) {
     * 
     * RegistrationResponse r = new RegistrationResponse(); int usuarioCreadoId =
     * usuarioService.crearUsuario(req.nombre, req.dni, req.edad, req.email,
     * req.password);
     * 
     * r.isOk = true; r.message = "Te registraste con exito"; r.usuarioId =
     * usuarioCreadoId;
     * 
     * return r; }
     */
    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/auth/register")
    public RegistrationResponse postRegisterUser(@RequestBody RegistrationRequest req) throws PersonaEdadException {
        RegistrationResponse r = new RegistrationResponse();
        // aca creamos la persona y el usuario a traves del service.

        int usuarioCreadoId = usuarioService.alta(req.nombre, req.dni, req.email, req.edad, req.password, req.moneda,
                req.email);

        r.isOk = true;
        r.message = "Te registraste con exito";
        r.usuarioId = usuarioCreadoId;
        return r;
    }
}