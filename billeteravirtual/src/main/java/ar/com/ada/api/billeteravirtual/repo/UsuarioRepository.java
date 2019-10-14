package ar.com.ada.api.billeteravirtual.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.billeteravirtual.entities.Usuario;

/**
 * UsuarioRepository
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByUserName(String nombrePersona);

    Usuario findByUserEmail(String email);

}