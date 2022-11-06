package com.amaressantana.minhaslojasdigitais.model;

import com.amaressantana.minhaslojasdigitais.model.entitypk.OderItemPk;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    private static final long serialVersionUID=1L;

    @EmbeddedId
    private OderItemPk id;
    private Integer quantity;
    private Double price;

    public OrderItem(Oder oder, Product product, Integer quantity, Double price) {
        id.setOrder(oder);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }
    public OrderItem(){

    }

    public Oder getOder(){
        return id.getOrder();
    }
    public void setOder(Oder oder){
        id.setOrder(oder);
    }

    public Product getProduct(){
        return id.getProduct();
    }
    public void setProduct(Product product){
        id.setProduct(product);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
