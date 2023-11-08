package com.example.testbackend.controller;

import com.example.testbackend.model.Price;
import com.example.testbackend.service.ProductService;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.text.ParseException;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Value("${errorMessage}")
    public String errorMessage;
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/prices")
    public ResponseEntity<Object> getTaxesByDateTime(@RequestParam("productId") Integer productId, @RequestParam("chainId") Integer chainId, @RequestParam("applyDate") String applyDate) {
        try {
            return new ResponseEntity<>(productService.getPriceByDate(productId, chainId, applyDate), HttpStatus.OK);
        } catch (ParseException e) {
            return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
        }

    }
}