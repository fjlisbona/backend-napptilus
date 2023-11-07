package com.example.testbackend.controller;

import com.example.testbackend.model.Price;
import com.example.testbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping(value = "/")
    public List<Price> getAllTaxes(){
        return  productService.getTaxes();
    }

    @GetMapping(value = "/prices")
    public ResponseEntity<ProductResponse> getTaxesByDateTime(@RequestParam("productId") Integer productId,@RequestParam("chainId")Integer chainId,@RequestParam("applyDate") String applyDate) throws ParseException {


       SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");//"yyyy-MM-dd HH:mm:ss"

        ProductResponse productResponse= productService.getPriceByDate(productId,chainId,originalFormat.parse(applyDate)).getBody();
         return new ResponseEntity<ProductResponse>(productResponse, HttpStatus.OK);

    }
}