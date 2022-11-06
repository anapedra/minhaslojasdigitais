package com.amaressantana.minhaslojasdigitais.DTOS;

import com.amaressantana.minhaslojasdigitais.model.Product;
import jakarta.validation.constraints.NotBlank;

import java.util.*;

public class CategoryProductDTO {
    @NotBlank
    private String nome;
    private List<Product> products=new ArrayList<>();

    public CategoryProductDTO(){

    }

    public List<Product> getProducts() {
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
