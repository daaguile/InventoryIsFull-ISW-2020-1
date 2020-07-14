package com.inventoryisfull.domain;

import java.util.Set;

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
    @Column(name = "idPabellon")
    private Long id;

    @NotNull
    private int sala;

    @NotNull
    private String descripcion;

    @NotNull
    private String estado;

    @OneToMany(mappedBy = "Pabellon")
    private Set<Registro> registro; 


    public Pabellon() {
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripción) {
        this.descripcion = descripción;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<Registro> getRegistro() {
        return registro;
    }

    public void setRegistro(Set<Registro> registro) {
        this.registro = registro;
    }

    public Pabellon(Long id) {
        this.id = id;
    }

    

}