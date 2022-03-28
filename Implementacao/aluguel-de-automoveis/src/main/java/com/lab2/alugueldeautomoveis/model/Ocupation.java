package com.lab2.alugueldeautomoveis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_ocupation")
public class Ocupation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String enterprise;
    private Float paymant;

    public Long getId() {
        return this.id;
    }

    public String getEnterprise() {
        return this.enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public Float getPaymant() {
        return this.paymant;
    }

    public void setPaymant(Float paymant) {
        this.paymant = paymant;
    }

}
