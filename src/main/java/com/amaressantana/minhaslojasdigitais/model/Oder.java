package com.amaressantana.minhaslojasdigitais.model;

import com.amaressantana.minhaslojasdigitais.model.entitysenus.OrderStatos;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_oder")
public class Oder implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern ="yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
    private Instant dataCriacao;
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern ="yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
    private Instant dataAtualizacao;
    private Integer orderStatos;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Oder(){

    }

    public Oder(Long id, Instant dataCriacao, Instant dataAtualizacao,OrderStatos orderStatos, User user) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        setOrderStatos(orderStatos);
        this.user = user;
    }
    @Override
    public String toString() {
        return "Oder{" +
                "id=" + id +
                ", dataCriacao=" + dataCriacao +
                ", dataAtualizacao=" + dataAtualizacao +
                ", orderStatos=" + orderStatos +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Oder)) return false;
        Oder oder = (Oder) o;
        return Objects.equals(getId(), oder.getId()) && Objects.equals(getDataCriacao(), oder.getDataCriacao()) && Objects.equals(getDataAtualizacao(), oder.getDataAtualizacao()) && getOrderStatos() == oder.getOrderStatos() && Objects.equals(getUser(), oder.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDataCriacao(), getDataAtualizacao(), getOrderStatos(), getUser());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Instant dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Instant getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Instant dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public OrderStatos getOrderStatos() {
        return OrderStatos.valueOf(orderStatos);
    }

    public void setOrderStatos(OrderStatos orderStatos) {
        if (orderStatos != null){
        this.orderStatos = orderStatos.getCode();
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}



