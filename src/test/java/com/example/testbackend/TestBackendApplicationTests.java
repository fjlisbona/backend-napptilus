package com.example.testbackend;

import com.example.testbackend.controller.ProductRequest;
import com.example.testbackend.controller.ProductResponse;
import com.example.testbackend.model.Price;
import com.example.testbackend.repository.ProductRepo;

import com.example.testbackend.util.DateMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;



import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class TestBackendApplicationTests {

    @Autowired
    private ProductRepo productRepo;

    private ProductRequest productRequest;

    private ProductResponse productResponse;
    @Autowired
    private  DateMapper dateMapper ;
   @Test
    void test1() throws Exception {
        // Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1
        String applyDate = "2020-06-14T10:00:00Z";
       productRequest=new ProductRequest(dateMapper.parseDate(applyDate),35455,1);
       productResponse=new ProductResponse(35455,dateMapper.parseDate(applyDate),new BigDecimal("35.50"),1,1);

        Price result = productRepo.findPriceByDate(productRequest);
        assertEquals(result.getPrice(), productResponse.price());


    }

    @Test
    public void test2() throws ParseException {
        //Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1

        String applyDate = "2020-06-14T16:00:00Z";
        productRequest=new ProductRequest(dateMapper.parseDate(applyDate),35455,1);
        productResponse=new ProductResponse(35455,dateMapper.parseDate(applyDate),new BigDecimal("25.45"),2,1);

        Price result = productRepo.findPriceByDate(productRequest);

      assertEquals(result.getPrice(),productResponse.price());


    }

    @Test
    public void test3() throws ParseException {
        //Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1
        String applyDate = "2020-06-14T21:00:00Z";
        productRequest=new ProductRequest(dateMapper.parseDate(applyDate),35455,1);
        productResponse=new ProductResponse(35455,dateMapper.parseDate(applyDate),new BigDecimal("35.50"),1,1);
        Price result = productRepo.findPriceByDate(productRequest);
        assertEquals(result.getPrice(),productResponse.price());

    }

    @Test
    public void test4() throws ParseException {
        //Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1


        String applyDate = "2020-06-15T10:00:00Z";
        productRequest=new ProductRequest(dateMapper.parseDate(applyDate),35455,1);
        productResponse=new ProductResponse(35455,dateMapper.parseDate(applyDate),new BigDecimal("30.50"),3,1);

        //Expected response value

        Price result = productRepo.findPriceByDate(productRequest);
        assertEquals(result.getPrice(),productResponse.price());

    }

    @Test
    public void test5() throws ParseException {
        //Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1
        String applyDate = "2020-06-16T21:00:00Z";
        productRequest=new ProductRequest(dateMapper.parseDate(applyDate),35455,1);
        //Expected response value
        productResponse=new ProductResponse(35455,dateMapper.parseDate(applyDate),new BigDecimal("38.95"),4,1);

        Price result = productRepo.findPriceByDate(productRequest);
        assertEquals(result.getPrice(),productResponse.price());
    }
}

