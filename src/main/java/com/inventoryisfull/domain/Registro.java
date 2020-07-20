package com.inventoryisfull.domain;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
@Entity
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonProperty("idPaciente")
    @JoinColumn(name = "idPaciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JsonProperty("idPabellon")
    @JoinColumn(name = "idPabellon", nullable = false)
    private Pabellon pabellon;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaIngreso;

    @NotNull
    @DateTimeFormat(pattern = "hh:mm:ss")
    private Time horaIngreso;
    
    @NotNull
    @DateTimeFormat(pattern = "hh:mm:ss")
    private Time horaSalida;

    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date fecha;

    @NotNull
    private String motivo;

    public Registro() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("idPaciente")
    public Paciente getPaciente() {
        return paciente;
    }

    @JsonProperty("idPaciente")
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @JsonProperty("idPabellon")
    public Pabellon getPabellon() {
        return pabellon;
    }

    @JsonProperty("idPabellon")
    public void setPabellon(Pabellon pabellon) {
        this.pabellon = pabellon;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Time getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(Time horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Time getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }

    
}