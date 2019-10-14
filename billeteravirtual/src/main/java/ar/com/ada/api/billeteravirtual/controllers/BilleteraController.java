package ar.com.ada.api.billeteravirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.billeteravirtual.models.request.TransferRequest;
import ar.com.ada.api.billeteravirtual.models.response.SaldoResponse;
import ar.com.ada.api.billeteravirtual.models.response.TransferResponse;
import ar.com.ada.api.billeteravirtual.services.BilleteraService;

/**
 * BilleteraController
 */
@RestController
public class BilleteraController {

    @Autowired
    BilleteraService billeteraService;

    @PostMapping("transferencia")
    public TransferResponse postTransfer(@RequestBody TransferRequest req) {
        TransferResponse t = new TransferResponse();
        billeteraService.crearTransferencia(req.importe, req.billeteraIdOrigen, req.emailDestino);
        t.isOk = true;
        t.message = "Transferencia exitosa";
        return t;
    }

    @GetMapping("/billeteras/{id}/saldos")
    public SaldoResponse GetSaldoBilleteraById(@PathVariable int id) {
        SaldoResponse s = new SaldoResponse();
        s.idBilletera = id;
        s.saldo = billeteraService.buscarPorId(id).cuentaPrincipal().getSaldo();
        s.moneda = billeteraService.buscarPorId(id).cuentaPrincipal().getMoneda();
        return s;
    }
}
