package ar.com.ada.api.challenge.challengenasa.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Temperatura
 */
@Entity
@Table (name ="temperatura")
public class Temperatura {
    @Id
    @Column(name = "temperatura_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer temperaturaId;
    public String pais;
    @Column (name = "anio_temperatura")
    public int anioTemperatura;
    public Double grados;

    // @ManyToOne("")


    public Temperatura(Integer temperaturaId, String pais, int anioTemperatura, Double grados) {
        this.temperaturaId = temperaturaId;
        this.pais = pais;
        this.anioTemperatura = anioTemperatura;
        this.grados = grados;
    }

    public Temperatura() {
    }

    public Integer getTemperaturaId() {
        return temperaturaId;
    }

    public void setTemperaturaId(Integer temperaturaId) {
        this.temperaturaId = temperaturaId;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getAnioTemperatura() {
        return anioTemperatura;
    }

    public void setAnioTemperatura(int anioTemperatura) {
        this.anioTemperatura = anioTemperatura;
    }

    public Double getGrados() {
        return grados;
    }

    public void setGrados(Double grados) {
        this.grados = grados;
    }

	public void add(List<Temperatura> temperaturas) {
	}

    
}