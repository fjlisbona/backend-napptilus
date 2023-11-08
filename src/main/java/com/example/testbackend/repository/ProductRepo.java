package com.example.testbackend.repository;

import com.example.testbackend.controller.ProductRequest;

import com.example.testbackend.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;



@Repository
public interface ProductRepo extends JpaRepository<Price, Long> {

@Query("SELECT p FROM Price p " +
        "WHERE :#{#request.applyDate} BETWEEN p.id.startDate AND p.id.endDate " +
        "AND p.id.productId= :#{#request.productId} " +
        "AND p.id.brandId=:#{#request.chainId} " +
        "ORDER BY p.priority DESC LIMIT 1")
    Price findPriceByDate(@Param("request") ProductRequest request);
}
