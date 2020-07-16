package com.inventoryisfull.domain;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPaciente")
    private Long id;


    @OneToMany(mappedBy = "paciente")
    private Set<Registro> registro;

    public Paciente() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Registro> getRegistro() {
        return registro;
    }

    public void setRegistro(Set<Registro> registro) {
        this.registro = registro;
    }

    public Paciente(Long id) {
        this.id = id;
    }

}