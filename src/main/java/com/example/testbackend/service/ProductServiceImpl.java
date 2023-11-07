package com.example.testbackend.service;

import com.example.testbackend.controller.ProductRequest;
import com.example.testbackend.controller.ProductResponse;
import com.example.testbackend.model.Price;
import com.example.testbackend.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.text.ParseException;

import java.util.Date;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    public List<Price> getTaxes() {
        return productRepo.findAll();

    }

    @Override
    public ResponseEntity<ProductResponse> getPriceByDate(Integer productId, Integer chainId, Date applyDate) throws ParseException {
        ProductRequest productRequest=new ProductRequest();
        productRequest.setChainId(chainId);
        productRequest.setProductId(productId);

        productRequest.setApplyDate(applyDate);
        Integer priorityMaxValue= productRepo.getPriorityMaxValue(productRequest);
        Price priceResponse = productRepo.findPriceByDate(productRequest, priorityMaxValue);
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductId(priceResponse.getId().getProductId());

        productResponse.setApplyDate(applyDate);
        productResponse.setTotalPrice(priceResponse.getPrice());
        productResponse.setPriceList(priceResponse.getId().getPriceList());
        productResponse.setChainId(priceResponse.getId().getBrandId());
        return new ResponseEntity<ProductResponse>(productResponse, HttpStatus.OK);
    }


}
