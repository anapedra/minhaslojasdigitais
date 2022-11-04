package com.amaressantana.minhaslojasdigitais.DTOS;

import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

public class UserDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String phone;

    UserDTO(){

    }

    public UserDTO(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTO)) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(getName(), userDTO.getName()) && Objects.equals(getEmail(), userDTO.getEmail()) && Objects.equals(getPhone(), userDTO.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getEmail(), getPhone());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
