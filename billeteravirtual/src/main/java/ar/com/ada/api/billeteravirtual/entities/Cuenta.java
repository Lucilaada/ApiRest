package ar.com.ada.api.billeteravirtual.entities;

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
    @Column(name = "dinero_disponible")
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


  /*  public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }*/

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
/*
    @Id
    @Column(name = "cuenta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int cuentaId;
    private String moneda;
    private double saldo;
    @Column(name = "saldo_disponible")
    private double saldoDisponible;
    // private String nroCuenta; // (univoco)

    @ManyToOne
    @JoinColumn(name = "billetera_id", referencedColumnName = "billetera_id")
    private Billetera billetera;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Movimiento> movimientos = new ArrayList<Movimiento>(); // (puede necesitar tabla intermedia)

    public Cuenta(int cuentaId, String moneda) {
        this.cuentaId = cuentaId;
        this.moneda = moneda;
    }

    public Cuenta() {
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Billetera getBilletera() {
        return billetera;
    }

    public void setBilletera(Billetera billetera) {
        this.billetera = billetera;
        this.billetera.getCuentas().add(this);
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public double getSaldoDisponible() {
        return saldo;
    }

    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

 /*   public Cuenta(Billetera b) {
        System.out.println("Creacion de cuenta. Seleccione la moneda: \n1: U$S \n2: AR$");
        int opcionMoneda = Teclado.nextInt();
        switch (opcionMoneda) {
        case 1:
            this.setMoneda("U$S");
            break;
        case 2:
            this.setMoneda("AR$");
            break;
        default:
            break;
        }*/

    

  /*  public Usuario getUsuario() {

        Usuario u = this.getBilletera().getPersona().getUsuario();
        return u;

    }

    public void agregarMovimiento(Movimiento movimiento) {
        this.movimientos.add(movimiento);
        movimiento.setCuenta(this);
        this.setSaldo(this.getSaldo() + movimiento.getImporte());
        this.setSaldoDisponible(this.getSaldo());
    }*/

}