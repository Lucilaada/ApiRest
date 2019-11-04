package ar.com.ada.api.challenge.challengenasa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.challenge.challengenasa.entities.Temperatura;
import ar.com.ada.api.challenge.challengenasa.repo.TemperaturaRepository;

/**
 * TemperaturaService
 */
@Service
public class TemperaturaService {

    @Autowired
    static TemperaturaRepository temperaturaRepository;
    @Autowired
    TemperaturaService temperaturaService;

    public void agregarTemperatura(String pais, int anioTemperatura, Double grados) {

        Temperatura t = new Temperatura();
        t.setPais(pais);
        t.setAnioTemperatura(anioTemperatura);
        t.setGrados(grados);
        temperaturaRepository.save(t);

    }

    public Temperatura buscarPorId(int id) {
        Optional<Temperatura> t = temperaturaRepository.findByTemperaturaId(id);

        if (t.isPresent())
            return t.get();
        return null;
    }
    
    	public void eliminaTemperatura(int temperaturaId) {
        Temperatura t = temperaturaService.buscarPorId(temperaturaId);
        t.setAnioTemperatura(0);
        temperaturaRepository.save(t);
	}
}