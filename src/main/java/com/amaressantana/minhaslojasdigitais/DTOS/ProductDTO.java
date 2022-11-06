package com.amaressantana.minhaslojasdigitais.DTOS;

import com.amaressantana.minhaslojasdigitais.model.CategoryProduct;
import jakarta.validation.constraints.NotBlank;

import java.util.*;

public class ProductDTO {
    @NotBlank
    private String name;
    @NotBlank
    private  String descricao;
    private String imgUri;
    private List<CategoryProduct> categorys = new ArrayList<>();


    public ProductDTO(){

    }

    public ProductDTO(String name, String descricao, String imgUri) {
        this.name = name;
        this.descricao = descricao;
        this.imgUri = imgUri;
    }


    public List<CategoryProduct> getCategorys() {
        return categorys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImgUri() {
        return imgUri;
    }

    public void setImgUri(String imgUri) {
        this.imgUri = imgUri;
    }
}
