package com.inventoryisfull.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
@Entity
public class Cama {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCama")
    private Long id;

    @NotNull
    private String descripcion;

    private String estado;

    @ManyToOne
    @JsonProperty("idRecuperacion")
    @JoinColumn(name = "idRecuperacion", nullable = true)
    private Recuperacion recuperacion;

    public Cama() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @JsonProperty("idRecuperacion")
    public Recuperacion getRecuperacion() {
        return recuperacion;
    }

    @JsonProperty("idRecuperacion")
    public void setRecuperacion(Recuperacion recuperacion) {
        this.recuperacion = recuperacion;
    }
    
    
    
}