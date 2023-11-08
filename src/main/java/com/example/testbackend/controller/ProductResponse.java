package com.example.testbackend.controller;




import java.math.BigDecimal;


import java.util.Date;


public record ProductResponse(Integer productId, Date date, BigDecimal price, Integer priceList, Integer brandId){}


