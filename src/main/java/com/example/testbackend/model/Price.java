package com.example.testbackend.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.EmbeddedId;
import lombok.Data;

@Data
@Entity
@Table(name = "PRICES")
public class Price {
    @EmbeddedId
    private PriceId id;
    private Integer priority;
    private BigDecimal price;
    private String currency;



}

