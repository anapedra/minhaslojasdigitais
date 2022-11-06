package com.amaressantana.minhaslojasdigitais.model.entitypk;

import com.amaressantana.minhaslojasdigitais.model.Oder;
import com.amaressantana.minhaslojasdigitais.model.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OderItemPk implements Serializable {
    private static final long serialVersionUID=1L;

    @ManyToOne
    @JoinColumn(name = "oder_id")
    private Oder oder;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Oder getOrder() {
        return oder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OderItemPk)) return false;
        OderItemPk that = (OderItemPk) o;
        return Objects.equals(oder, that.oder) && Objects.equals(getProduct(), that.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(oder, getProduct());
    }

    public void setOrder(Oder oder) {
        this.oder = oder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }



}
