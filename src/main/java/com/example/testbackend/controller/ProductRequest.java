package com.example.testbackend.controller;

import org.springframework.stereotype.Component;
import java.time.ZoneId;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Component
public class ProductRequest {

    private Date applyDate;
    private Integer productId;

    private Integer chainId;

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) throws ParseException {
        this.applyDate = applyDate;
    }

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
}
