package ar.com.ada.api.billeteravirtual.entities;

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

    public void movimientoTransferencia(double importe, Usuario usuarioOrigen, Usuario usuarioDestino) {
        Movimiento m = new Movimiento();
        m.setTipoOperacion("");
        m.setConceptoOperacion("Transferencia");
        m.setDetalle("Transferencia");
        m.setEstado(0);
        m.setImporte(importe);
        m.setFechaMovimiento(new Date());
        m.setDeUsuario(usuarioOrigen.getUsuarioId());
        m.setaUsuario(usuarioDestino.getUsuarioId());
        m.setCuentaOrigenId(usuarioOrigen.getPersona().getPersonaId());
        m.setCuentaDestinatarioId(usuarioDestino.getPersona().getPersonaId());
        this.cuentas.get(0).agregarMovimiento(m);
    }
}
