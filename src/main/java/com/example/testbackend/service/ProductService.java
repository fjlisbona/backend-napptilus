package com.example.testbackend.service;

import com.example.testbackend.controller.ProductRequest;
import com.example.testbackend.controller.ProductResponse;
import com.example.testbackend.model.Price;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


public interface ProductService {
    public List<Price> getTaxes();

    ResponseEntity<ProductResponse> getPriceByDate(Integer productId, Integer chainId, Date applyDate) throws ParseException;
}
