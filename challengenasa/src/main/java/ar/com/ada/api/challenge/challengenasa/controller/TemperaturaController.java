package ar.com.ada.api.challenge.challengenasa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.challenge.challengenasa.models.request.TemperaturaEliminacion;
import ar.com.ada.api.challenge.challengenasa.models.request.TemperaturaRequest;
import ar.com.ada.api.challenge.challengenasa.models.response.TemperaturaResponse;
import ar.com.ada.api.challenge.challengenasa.services.PaisService;
import ar.com.ada.api.challenge.challengenasa.services.TemperaturaService;

/**
 * TemperaturaController
 */
@RestController
public class TemperaturaController {
    @Autowired
    TemperaturaService temperaturaService;
    @Autowired
    PaisService paisService;

    @PostMapping("/temperaturas")
    public TemperaturaResponse postTemperatura(@RequestBody TemperaturaRequest req) throws Exception {

        TemperaturaResponse t = new TemperaturaResponse();

        temperaturaService.agregarTemperatura(req.pais, req.anioTemperatura, req.grados);

        t.isOk = true;
        t.message = "Temperatura agregada con exito.";

        return t;
    }

    @GetMapping("temperaturas/paises/{codigoPais}")
    public TemperaturaResponse GetTemperaturaById(@PathVariable int id) {
        TemperaturaResponse t = new TemperaturaResponse();
        t.anioTemperatura = paisService.buscarPorCodigoPais(id).codigoPais;
        return t;
    }

    @DeleteMapping("temperaturas/{id}")
    public TemperaturaResponse deleteTemperatura(@RequestBody TemperaturaEliminacion req) throws Exception {

        TemperaturaResponse t = new TemperaturaResponse();

        temperaturaService.eliminaTemperatura(req.temperaturaId);
        t.isOk = true;
        t.message = "Temperatura eliminada con exito.";
        return t;

    }
}