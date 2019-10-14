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

    public int crearUsuario(String nombre, String dni, Integer edad, String email, String password) {
        Usuario u = new Usuario();
        u.setUserEmail(email);
        u.setUserName(email);
        String passwordEnTextoClaro;
        String passwordEncriptada;
        String passwordEnTextoClaroDesencriptado;
        passwordEnTextoClaro = password;
        passwordEncriptada = Crypto.encrypt(passwordEnTextoClaro, u.getUserName());
        passwordEnTextoClaroDesencriptado = Crypto.decrypt(passwordEncriptada, u.getUserName());
        if (passwordEnTextoClaro.equals(passwordEnTextoClaroDesencriptado)) {
            u.setPassword(passwordEncriptada);
            Persona p = new Persona();
            p.setNombre(nombre);
            p.setEmail(email);
            p.setDni(dni);
            try {
                p.setEdad(edad);
            } catch (PersonaEdadException e) {
                e.printStackTrace();
            }
            Billetera b = new Billetera();
            Cuenta c = new Cuenta();
            b.agregarCuenta(c);
            usuarioRepository.save(u);

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

    public Usuario buscarPorEmail(String email){
    
        return usuarioRepository.findByUserEmail(email);
    }

}