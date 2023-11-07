package com.example.testbackend.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.EmbeddedId;


@Entity
@Table(name = "PRICES")
public class Price {
    @EmbeddedId
    private PriceId id;
    private Integer priority;
    private BigDecimal price;
    private String currency;

    public PriceId getId() {
        return id;
    }

    public void setId(PriceId id) {
        this.id = id;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public BigDecimal  getPrice() {
        return price;
    }

    public void setPrice(BigDecimal  price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}

