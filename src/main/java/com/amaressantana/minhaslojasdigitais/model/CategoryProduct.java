package com.amaressantana.minhaslojasdigitais.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_categoria_produto")
public class CategoryProduct implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryProduct)) return false;
        CategoryProduct that = (CategoryProduct) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @ManyToMany(mappedBy = "categorys")
    @JsonIgnore
    private Set<Product> products=new HashSet<>();

    public CategoryProduct(Long id, String nome, Set<Product> products) {
        this.id = id;
        this.nome = nome;
        this.products = products;
    }

    @Override
    public String toString() {
        return "CategoryProduct{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", products=" + products +
                '}';
    }

    public Set<Product> getProducts() {
        return products;
    }

    public CategoryProduct() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
