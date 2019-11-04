package ar.com.ada.api.challenge.challengenasa.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.challenge.challengenasa.entities.Temperatura;

/**
 * TemperaturaRepository
 */
@Repository
public interface TemperaturaRepository extends JpaRepository<Temperatura, Double>{
    Optional<Temperatura> findByTemperaturaId(Integer id);
    List<Temperatura> findAll();
    
}