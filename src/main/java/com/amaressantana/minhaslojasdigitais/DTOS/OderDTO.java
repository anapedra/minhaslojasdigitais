package com.amaressantana.minhaslojasdigitais.DTOS;

import com.amaressantana.minhaslojasdigitais.model.User;

import java.util.Objects;

public class OderDTO {
    private User cliente;

    public OderDTO(User cliente) {
        this.cliente = cliente;
    }
    public OderDTO(){

    }

    @Override
    public String toString() {
        return "OderDTO{" +
                "cliente=" + cliente +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OderDTO)) return false;
        OderDTO oderDTO = (OderDTO) o;
        return Objects.equals(cliente, oderDTO.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente);
    }

    public User getCliente() {
        return cliente;
    }

    public void setCliente(User cliente) {
        this.cliente = cliente;
    }
}
