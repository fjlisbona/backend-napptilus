package com.example.testbackend.service;

import com.example.testbackend.controller.ProductRequest;
import com.example.testbackend.controller.ProductResponse;
import com.example.testbackend.model.Price;
import com.example.testbackend.repository.ProductRepo;
import com.example.testbackend.util.DateMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final DateMapper dateMapper;

    public ProductServiceImpl(ProductRepo productRepo, DateMapper dateMapper) {
        this.productRepo = productRepo;
        this.dateMapper = dateMapper;
    }


    @Override
    public ProductResponse getPriceByDate(Integer productId, Integer chainId, String applyDate) throws ParseException {

        ProductRequest productRequest = new ProductRequest(dateMapper.parseDate(applyDate), productId, chainId);
        Price priceResponse = productRepo.findPriceByDate(productRequest);
        return new ProductResponse(priceResponse.getId().getProductId(), dateMapper.parseDate(applyDate),
                priceResponse.getPrice(), priceResponse.getId().getPriceList(), priceResponse.getId().getBrandId());

    }


}
