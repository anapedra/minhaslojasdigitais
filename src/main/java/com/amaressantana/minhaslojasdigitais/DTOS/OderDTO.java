package com.amaressantana.minhaslojasdigitais.DTOS;

import com.amaressantana.minhaslojasdigitais.model.User;

import java.util.Objects;

public class OderDTO {
    private User user;

    public OderDTO(){

    }

    public OderDTO(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "OderDTO{" +
                "user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OderDTO)) return false;
        OderDTO oderDTO = (OderDTO) o;
        return Objects.equals(getUser(), oderDTO.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

