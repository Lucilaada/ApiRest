package ar.com.ada.api.fiflix.fiflix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.fiflix.fiflix.entities.Serie;
import ar.com.ada.api.fiflix.fiflix.models.response.NuevaSerieResponse;
import ar.com.ada.api.fiflix.fiflix.services.NetflixService;

/**
 * NetflixController
 */
@RestController
public class NetflixController {
    @Autowired
    NetflixService netflixService;

    @PostMapping("api/series")
    public NuevaSerieResponse postRegisterUser(@RequestBody Serie reqSerie) {
        NuevaSerieResponse r = new NuevaSerieResponse();
        // aca creamos la persona y el usuario a travez del service.

        netflixService.grabar(reqSerie);

        r.isOk = true;
        r.message = "Te registraste con exitoooo";
        r.id = reqSerie.get_id().toString();
        return r;

    }

    @GetMapping("api/series")
    public ResponseEntity<?> GetSeries() throws Exception {

        List<Serie> series = netflixService.getCatalogoSeries();
        if (series.size() == 0)
            return (ResponseEntity<?>) ResponseEntity.notFound();

        return ResponseEntity.ok(series);

    }

}