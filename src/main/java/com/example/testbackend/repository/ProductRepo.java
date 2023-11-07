package com.example.testbackend.repository;

import com.example.testbackend.controller.ProductRequest;

import com.example.testbackend.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;



@Repository
public interface ProductRepo extends JpaRepository<Price, Long> {
    @Query("SELECT MAX(p2.priority) FROM Price p2  WHERE :#{#request.applyDate} BETWEEN p2.id.startDate AND p2.id.endDate AND p2.id.productId= :#{#request.productId} AND p2.id.brandId=:#{#request.chainId} ")
    Integer getPriorityMaxValue(@Param("request") ProductRequest request);
    @Query("SELECT p FROM Price p WHERE :#{#request.applyDate} BETWEEN p.id.startDate AND p.id.endDate AND p.id.productId= :#{#request.productId} AND p.id.brandId=:#{#request.chainId} AND p.priority=:#{#priorityMaxValue}")
    Price findPriceByDate(@Param("request") ProductRequest request,Integer priorityMaxValue);
}
