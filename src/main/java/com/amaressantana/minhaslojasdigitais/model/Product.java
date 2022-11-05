package com.amaressantana.minhaslojasdigitais.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_produto")
public class Product implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private  String descricao;
    @Column
    private String imgUri;
    @ManyToMany
    @JoinTable(name = "tb_product_category",joinColumns = @JoinColumn(name = "prodct_id"),inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<CategoryProduct> categorys = new HashSet<>();


    public Product(Long id, String name, String descricao, String imgUri) {
        this.id = id;
        this.name = name;
        this.descricao = descricao;
        this.imgUri = imgUri;
    }

    public Product() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getId(), product.getId()) && Objects.equals(getName(), product.getName()) && Objects.equals(getDescricao(), product.getDescricao()) && Objects.equals(getImgUri(), product.getImgUri()) && Objects.equals(getCategorys(), product.getCategorys());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescricao(), getImgUri(), getCategorys());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descricao='" + descricao + '\'' +
                ", imgUri='" + imgUri + '\'' +
                ", categorys=" + categorys +
                '}';
    }

    public Set<CategoryProduct> getCategorys() {
        return categorys;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
