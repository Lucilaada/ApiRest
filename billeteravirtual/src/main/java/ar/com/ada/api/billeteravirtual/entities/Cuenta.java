package ar.com.ada.api.billeteravirtual.entities;

import java.math.BigDecimal;
import java.util.*;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Cuenta
 */
@Entity
@Table(name = "cuenta")
public class Cuenta {
    @Id
    @Column(name = "cuenta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cuentaId;
   // @Column(name = "numero_cuenta")
    //private int numeroCuenta;
    private double saldo;
    @Column(name = "saldo_disponible")
    private double dineroDisponible;
    private String moneda;

    public Cuenta() {
    }

    @ManyToOne
    @JoinColumn(name = "billetera_id", referencedColumnName = "billetera_id")
    private Billetera billetera;

    @OneToMany( mappedBy = "cuenta", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Movimiento> movimientos = new ArrayList<Movimiento>();

    public Billetera getBilletera() {
        return billetera;
    }

    public void setBilletera(Billetera billetera) {
        this.billetera = billetera;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getDineroDisponible() {
        return dineroDisponible;
    }

    public void setDineroDisponible(double dineroDisponible) {
        this.dineroDisponible = dineroDisponible;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimiento(List<Movimiento> movimientos) {
        this.movimientos = movimientos;

    }

    public void agregarMovimiento(Movimiento movimiento){
        this.movimientos.add(movimiento);
        movimiento.setCuenta(this);
        this.setSaldo(this.getSaldo() + movimiento.getImporte());
        this.setDineroDisponible(this.getSaldo());
    }

    public Integer getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Integer cuentaId) {
        this.cuentaId = cuentaId;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public Cuenta(Billetera b, String moneda) {
        this.moneda = moneda;
        this.billetera = b;
        b.getCuentas().add(this);
    }
    public void movimientoTransferencia(int usuarioDe, String concepto, BigDecimal importe, String detalle) {
        Movimiento m = new Movimiento();
        m.setCuenta(this);
        m.setTipoOperacion("INGRESO");
        m.setImporte(importe);
        m.setConceptoOperacion(concepto);
        m.setDetalle(detalle);
        m.setFechaMovimiento(new Date());
        m.setDeUsuario(usuarioDe);
        m.setaUsuario(usuarioDe);
        m.setCuentaDestinatarioId(this.cuentaId);
        m.setCuentaOrigenId(this.cuentaId);

       /*Movimiento m = new Movimiento();
        m.setTipoOperacion("Salida");
        m.setConceptoOperacion("Transferencia");
        m.setDetalle("Transferencia");
        m.setEstado("Activo");
        m.setImporte(importe);
        m.setFechaMovimiento(new Date());
        m.setDeUsuario(usuarioOrigen.getUsuarioId());
        m.setaUsuario(usuarioDestino.getUsuarioId());
        m.setCuentaOrigenId(usuarioOrigen.getPersona().getPersonaId());
        m.setCuentaDestinatarioId(usuarioDestino.getPersona().getPersonaId());
        this.cuentas.get(0).agregarMovimiento(m);
        m.setCuenta(this.cuentas.get(0));*/
        this.movimientos.add(m);
    }
}
