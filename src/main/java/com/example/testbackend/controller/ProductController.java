package com.example.testbackend.controller;

import com.example.testbackend.model.Price;
import com.example.testbackend.service.ProductService;

import com.example.testbackend.util.DateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.text.ParseException;





@RestController
@RequestMapping("/api/products")
public class ProductController {


    private  ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @GetMapping(value = "/prices")
    public ResponseEntity<ProductResponse> getTaxesByDateTime(@RequestParam("productId") Integer productId, @RequestParam("chainId")Integer chainId, @RequestParam("applyDate") String applyDate ) throws ParseException {
        // Use the DateMapper to parse the date string
        // Assuming the DateMapper has a method like `parseDate`
        // Adjust the method name accordingly to your implementation

         return new ResponseEntity<ProductResponse>(productService.getPriceByDate(productId,chainId,applyDate), HttpStatus.OK);

    }
}