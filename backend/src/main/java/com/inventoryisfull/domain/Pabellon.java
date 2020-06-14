package com.inventoryisfull.domain;

import javax.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.NotNull;

@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
@Entity
public class Pabellon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private int piso;

    @NotNull
    private String servicio;

    @NotNull
    private String especialidad;

    @NotNull
    private String medicoJefeNombre;

    @NotNull
    private String medicoJefeApellido;

    public Pabellon() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getMedicoJefeNombre() {
        return medicoJefeNombre;
    }

    public void setMedicoJefeNombre(String medicoJefeNombre) {
        this.medicoJefeNombre = medicoJefeNombre;
    }

    public String getMedicoJefeApellido() {
        return medicoJefeApellido;
    }

    public void setMedicoJefeApellido(String medicoJefeApellido) {
        this.medicoJefeApellido = medicoJefeApellido;
    }

}