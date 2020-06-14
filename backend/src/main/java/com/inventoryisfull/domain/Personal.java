package com.inventoryisfull.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "personal")
public class Personal {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name="rut", unique=true)
    private String rut;

    @NotNull
    private String nombre;

    @NotNull
    private String ocupacion;

    @NotNull
    private String area;

    public Long getId() {
        return id;
    }

    public String getRut() {
		return this.rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
    }
    
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOcupacion() {
        return this.ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}