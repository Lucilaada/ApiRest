package ar.com.ada.api.billeteravirtual.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.billeteravirtual.entities.Billetera;
import ar.com.ada.api.billeteravirtual.entities.Cuenta;
import ar.com.ada.api.billeteravirtual.entities.Persona;
import ar.com.ada.api.billeteravirtual.entities.Usuario;
import ar.com.ada.api.billeteravirtual.excepciones.PersonaEdadException;
import ar.com.ada.api.billeteravirtual.repo.UsuarioRepository;
import ar.com.ada.api.billeteravirtual.security.Crypto;

/**
 * UsuarioService
 */
@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    PersonaService personaService;
    @Autowired
    BilleteraService billeteraService;
    @Autowired
    CuentaService cuentaService;

    public int alta(String nombre, String dni, String email, Integer edad, String password, String moneda, String userEmail) {
        Persona p = new Persona();
        p.setNombre(nombre);
        p.setEmail(email);
        p.setDni(dni);
        try {
            p.setEdad(edad);
        } catch (PersonaEdadException e) {
            e.printStackTrace();
        }

        Usuario u = new Usuario();
        u.setUserEmail(p.getEmail());
        u.setUsername(p.getEmail());

        String passwordEnTextoClaro;
        String passwordEncriptada;
        String passwordEnTextoClaroDesencriptado;

        passwordEnTextoClaro = password;
        passwordEncriptada = Crypto.encrypt(passwordEnTextoClaro, u.getUsername());
        passwordEnTextoClaroDesencriptado = Crypto.decrypt(passwordEncriptada, u.getUsername());
        if (passwordEnTextoClaro.equals(passwordEnTextoClaroDesencriptado)) {
            u.setPassword(passwordEncriptada);
            p.setUsuario(u);
            personaService.save(p);

            Billetera b = new Billetera(p);
            Cuenta c = new Cuenta(b, moneda);
            //b.agregarCuenta(c);
            //usuarioRepository.save(u);
          //  c.setMoneda("ARS");

            c.setBilletera(b);
          //  cuentaService.save(c);
           // b.agregarCuenta(c);
            billeteraService.save(b);

            personaService.save(p);

            return u.getUsuarioId();

        } else {
        }
        return u.getUsuarioId();
    }

    public List<Usuario> getUsuarios() {

        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(int id) {

        Optional<Usuario> u = usuarioRepository.findById(id);

        if (u.isPresent())
            return u.get();
        return null;
    }

    public Usuario save(Usuario u) {
        return usuarioRepository.save(u);

    }

    public Usuario buscarPorEmail(String email) {

        return usuarioRepository.findByUserEmail(email);
    }

}