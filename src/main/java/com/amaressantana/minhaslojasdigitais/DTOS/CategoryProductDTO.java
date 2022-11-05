package com.amaressantana.minhaslojasdigitais.DTOS;

import com.amaressantana.minhaslojasdigitais.model.Product;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CategoryProductDTO {
    @NotBlank
    private String nome;
    private Set<Product> products=new HashSet<>();

    public CategoryProductDTO(){

    }

    @Override
    public String toString() {
        return "CategoryProductDTO{" +
                "nome='" + nome + '\'' +
                ", products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryProductDTO)) return false;
        CategoryProductDTO that = (CategoryProductDTO) o;
        return Objects.equals(getNome(), that.getNome()) && Objects.equals(getProducts(), that.getProducts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getProducts());
    }

    public Set<Product> getProducts() {
        return products;
    }

    public CategoryProductDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
