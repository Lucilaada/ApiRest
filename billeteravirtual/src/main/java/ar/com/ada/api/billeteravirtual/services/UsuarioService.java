package ar.com.ada.api.billeteravirtual.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import ar.com.ada.api.billeteravirtual.entities.Billetera;
import ar.com.ada.api.billeteravirtual.entities.Cuenta;
import ar.com.ada.api.billeteravirtual.entities.Persona;
import ar.com.ada.api.billeteravirtual.entities.Usuario;
import ar.com.ada.api.billeteravirtual.excepciones.PersonaEdadException;
import ar.com.ada.api.billeteravirtual.repo.UsuarioRepository;
import ar.com.ada.api.billeteravirtual.security.Crypto;
import ar.com.ada.api.billeteravirtual.sistema.sistema.comms.EmailService;

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
    @Autowired
    EmailService emailService;


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
            p.setBilletera(b);
            Cuenta c = new Cuenta(b, moneda);
            c.setMoneda("ARS"); // Moneda inicial en ARS.
            b.agregarCuenta(c);
          //  b.agregarCuenta(c);
            //usuarioRepository.save(u);
          //  c.setMoneda("ARS");

          //  c.setBilletera(b);
          //  cuentaService.save(c);
           // b.agregarCuenta(c);
            billeteraService.save(b);

            personaService.save(p);


        BigDecimal plataInicial = new BigDecimal(100); 
        b.agregarPlata(plataInicial, "ARS", "Regalo", "Te regalo 100 pesitos");

        emailService.SendEmail(u.getUserEmail(),"Bienvenido a la Billetera Virtual ADA!!!", 
        "Hola "+p.getNombre()+"\nBienvenido a este hermoso proyecto hecho por todas las alumnas de ADA Backend 8va Mañana\n"+
        "Ademas te regalamos 100 pesitos" );
    
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

    public Usuario buscarPorUsername(String username) {

        return usuarioRepository.findByUsername(username);

    }
    public void login(String username, String password) {

        Usuario u = usuarioRepository.findByUsername(username);

        if (u == null || !u.getPassword().equals(Crypto.encrypt(password, u.getUsername()))) {

            throw new BadCredentialsException("Usuario o contraseña invalida");
        }

    }

}