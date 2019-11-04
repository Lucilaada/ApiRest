package ar.com.ada.api.challenge.challengenasa.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.challenge.challengenasa.entities.Pais;

/**
 * PaisRepository
 */
public interface PaisRepository extends JpaRepository<Pais, String> {

	Pais findByCodigoPais(int codigoPais);
	// Optional<Pais> findByCodigoPais();

    
}