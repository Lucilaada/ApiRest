package ar.com.ada.api.challenge.challengenasa.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Pais
 */
@Entity
@Table(name = "pais")
public class Pais {

    public String nombre;

    @Id
    @Column(name = "codigo_pais")
    public int codigoPais;

    @OneToMany
    (mappedBy = "pais", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Temperatura> temperaturas = new ArrayList<Temperatura>();

    public Pais(String nombre, int codigoPais, List<Temperatura> temperaturas) {
        this.nombre = nombre;
        this.codigoPais = codigoPais;
        this.temperaturas = temperaturas;
    }

    public Pais() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(int codigoPais) {
        this.codigoPais = codigoPais;
    }

    public List<Temperatura> getTemperaturas() {
        return temperaturas;
    }

    public void setTemperaturas(List<Temperatura> temperaturas) {
        this.temperaturas = temperaturas;
    }

  /*  public void agregarTemperatura(Temperatura temperatura{
        temperatura.setPais(this);
        
        temperaturas.add(temperatura);
    }*/
    
    
}