package ar.com.ada.api.billeteravirtual.entities;

import java.math.BigDecimal;
import java.util.*;

import javax.persistence.*;

/**
 * Billetera
 */
@Entity
@Table(name = "billetera")
public class Billetera {

    @Id
    @Column(name = "billetera_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer billeteraId;

    @OneToMany(mappedBy = "billetera", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Cuenta> cuentas = new ArrayList<Cuenta>();

    @OneToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "persona_id")
    private Persona persona;

    public Billetera() {
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;

    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public Cuenta cuentaPrincipal() {
        return getCuentas().get(0);
    }

    public Integer getBilleteraId() {
        return billeteraId;
    }

    public void setBilleteraId(Integer billeteraId) {
        this.billeteraId = billeteraId;
    }

    public void agregarCuenta(Cuenta cuenta) {
        cuenta.setBilletera(this);
        cuentas.add(cuenta);
    }

    private Cuenta buscarCuenta(String moneda) {
        for (Cuenta cta : this.cuentas) {
            if (moneda.equals(cta.getMoneda())) {
                return cta;
            }

        }

        return null;
    }

    public void agregarPlata(BigDecimal plata, String moneda, String concepto, String detalle) {
        // Agarro el primero y le meto plata (esto se hacia antes porqeu le agregaba a
        // la primer cuenta)
        this.buscarCuenta(moneda).movimientoTransferencia(persona.getUsuario().getUsuarioId(), concepto, plata,
                detalle);

    }

    public Billetera(Persona p) {
        this.setPersona(p);
        p.setBilletera(this);
    }

}
