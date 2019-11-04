package ar.com.ada.api.challenge.challengenasa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.challenge.challengenasa.entities.Pais;
import ar.com.ada.api.challenge.challengenasa.repo.PaisRepository;

/**
 * PaisService
 */
@Service
public class PaisService {
    @Autowired
    PaisRepository paisRepository;
    // @Autowired
    // PaisService paisService;

    public void altaPais(String nombre, int codigoPais) {

        Pais p = new Pais();
        p.setNombre(nombre);
        p.setCodigoPais(codigoPais);
        paisRepository.save(p);

    }

    public List<Pais> getPaises() {

        return paisRepository.findAll();
    }

    public Pais buscarPorCodigoPais(int codigoPais) {
        return paisRepository.findByCodigoPais(codigoPais);
    }

    public void modificaPais(String nombre, int codigoPais) {
        Pais p = this.buscarPorCodigoPais(codigoPais);
        p.setNombre(nombre);
        p.setCodigoPais(codigoPais);
        paisRepository.save(p);

    }
}