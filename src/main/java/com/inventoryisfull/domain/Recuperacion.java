package com.inventoryisfull.domain;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
@Entity
public class Recuperacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSalaRecuperación")
    private Long id;

    @NotNull
    private int piso;

    @NotNull
    private int numero;

    @OneToMany(mappedBy = "recuperacion")
    private Set<Cama> cama;

    public Recuperacion() {
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Set<Cama> getCama() {
        return cama;
    }

    public void setCama(Set<Cama> cama) {
        this.cama = cama;
    }


    
}