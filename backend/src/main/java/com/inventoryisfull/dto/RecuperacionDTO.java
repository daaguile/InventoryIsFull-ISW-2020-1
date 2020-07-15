package com.inventoryisfull.dto;

import net.minidev.json.JSONArray;

public class RecuperacionDTO {

    private Long id;
    private int piso;
    private int numero;
    private JSONArray camas;

    public RecuperacionDTO() {
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

    public JSONArray getCamas() {
        return camas;
    }

    public void setCamas(JSONArray camas) {
        this.camas = camas;
    }



    
    
}