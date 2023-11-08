package com.example.testbackend.service;

import com.example.testbackend.controller.ProductResponse;
import com.example.testbackend.model.Price;

import java.text.ParseException;
import java.util.List;


public interface ProductService {


    ProductResponse getPriceByDate(Integer productId, Integer chainId, String applyDate) throws ParseException;
}
