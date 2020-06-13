package com.inventoryisfull.domain;

import javax.persistence.*;

@Entity
@Table(name = "personal")
public class Personal {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Long id;


    @Column(name="rut", unique=true)
    private String rut;

	@Column(name="nombre")
    private String nombre;

    @Column(name="ocupacion")
    private String ocupacion;

    @Column(name="area")
    private String area;

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