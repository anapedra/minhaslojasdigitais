package com.amaressantana.minhaslojasdigitais.DTOS;

import com.amaressantana.minhaslojasdigitais.model.CategoryProduct;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ProductDTO {
    @NotBlank
    private String name;
    @NotBlank
    private  String descricao;
    private String imgUri;
    private Set<CategoryProduct> categorys = new HashSet<>();

    public ProductDTO(){

    }

    public ProductDTO(String name, String descricao, String imgUri) {
        this.name = name;
        this.descricao = descricao;
        this.imgUri = imgUri;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                ", descricao='" + descricao + '\'' +
                ", imgUri='" + imgUri + '\'' +
                ", categorys=" + categorys +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDTO)) return false;
        ProductDTO that = (ProductDTO) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getDescricao(), that.getDescricao()) && Objects.equals(getImgUri(), that.getImgUri()) && Objects.equals(getCategorys(), that.getCategorys());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescricao(), getImgUri(), getCategorys());
    }

    public Set<CategoryProduct> getCategorys() {
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
