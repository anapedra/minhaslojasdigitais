package com.amaressantana.minhaslojasdigitais.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_payment")
public class Payment implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant momentPayment;
    @OneToOne
    @MapsId
    private Oder oder;

    public Payment(Long id, Instant momentPayment, Oder oder) {
        this.id = id;
        this.momentPayment = momentPayment;
        this.oder = oder;
    }

    public Payment() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return Objects.equals(getId(), payment.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMomentPayment() {
        return momentPayment;
    }

    public void setMomentPayment(Instant momentPayment) {
        this.momentPayment = momentPayment;
    }

    public Oder getOder() {
        return oder;
    }

    public void setOder(Oder oder) {
        this.oder = oder;
    }
}
