package ar.com.ada.api.challenge.challengenasa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.challenge.challengenasa.entities.Pais;
import ar.com.ada.api.challenge.challengenasa.models.request.PaisModificacionRequest;
import ar.com.ada.api.challenge.challengenasa.models.request.PaisRequest;
import ar.com.ada.api.challenge.challengenasa.models.response.PaisResponse;
import ar.com.ada.api.challenge.challengenasa.services.PaisService;

/**
 * PaisController
 */
@RestController
public class PaisController {
    @Autowired
    PaisService paisService;

    @PostMapping("/paises")
    public PaisResponse postRegisterPais(@RequestBody PaisRequest req) throws Exception {
        PaisResponse r = new PaisResponse();

        paisService.altaPais(req.nombre, req.codigoPais);

        r.isOk = true;
        r.message = "Pais creado con exito";
        return r;

    }

    @GetMapping("paises/")
    public List<Pais> GetPaises() {
        List<Pais> p = paisService.getPaises();

        return p;
    }

    @GetMapping("paises/{id}")
    public Pais GetPaisById(@PathVariable int id) {
        Pais p = paisService.buscarPorCodigoPais(id);

        return p;
    }

    @PutMapping("paises/{id}")
    public PaisResponse putPais(@RequestBody PaisModificacionRequest req) throws Exception {

        PaisResponse p = new PaisResponse();

        paisService.modificaPais(req.nombre, req.codigoPais);

        p.isOk = true;
        p.message = "Su modificacion se registro con exito";

        return p;
    }

}