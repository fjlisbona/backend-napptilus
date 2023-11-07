package com.example.testbackend.controller;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@Component
public class ProductResponse {
    private Integer productId;
    private Integer chainId;

    //Identificador de la tarifa de precios aplicable que es la tarifa a aplicar.
    private Integer priceList;
    private Date applyDate;

    private BigDecimal price;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getChainId() {
        return chainId;
    }

    public void setChainId(Integer chainId) {
        this.chainId = chainId;
    }

    public Integer getPriceList() {
        return priceList;
    }

    public void setPriceList(Integer priceList) {
        this.priceList = priceList;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;

    }

    public BigDecimal getTotalPrice() {
        return price;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.price = totalPrice;
    }
}
