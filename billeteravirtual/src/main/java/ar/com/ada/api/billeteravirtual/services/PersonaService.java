package ar.com.ada.api.billeteravirtual.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.billeteravirtual.entities.Persona;
import ar.com.ada.api.billeteravirtual.repo.PersonaRepository;

/**
 * PersonaService
 */
@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    public void crearPersona(Persona p){
        personaRepository.save(p);
    
    }
    
    public Persona save(Persona p) {
        return personaRepository.save(p);
        
    }

    public List<Persona> getPersonas() {

        return personaRepository.findAll();
    }

    public Persona buscarPorNombre(String nombre) {

        return personaRepository.findByNombre(nombre);
    }
 
    
    public Persona buscarPorDni(String dni) {

        return personaRepository.findByDni(dni);
    }

    public Persona buscarPorId(Integer id) {

        Optional<Persona> p = personaRepository.findById(id);
        
        if (p.isPresent())
            return p.get();
        return null;
    }

	public List<Persona> buscarPersonasOrdenadoPorNombre() {
		return null;
	}

	public List<Persona> buscarTodosPorNombre(String nombre) {
		return null;
	}
        
}