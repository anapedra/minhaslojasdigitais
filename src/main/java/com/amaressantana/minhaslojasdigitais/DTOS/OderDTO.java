package com.amaressantana.minhaslojasdigitais.DTOS;

import com.amaressantana.minhaslojasdigitais.model.User;
import com.amaressantana.minhaslojasdigitais.model.entitysenus.OrderStatos;

import java.util.Objects;

public class OderDTO {
    private User user;
    private OrderStatos orderStatos;

    public OderDTO(){

    }

    public OderDTO(User user,OrderStatos orderStatos) {
        this.user = user;
        this.orderStatos=orderStatos;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "OderDTO{" +
                "user=" + user +
                ", orderStatos=" + orderStatos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OderDTO)) return false;
        OderDTO oderDTO = (OderDTO) o;
        return Objects.equals(getUser(), oderDTO.getUser()) && getOrderStatos() == oderDTO.getOrderStatos();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getOrderStatos());
    }

    public OrderStatos getOrderStatos() {
        return orderStatos;
    }

    public void setOrderStatos(OrderStatos orderStatos) {
        this.orderStatos = orderStatos;
    }
}

