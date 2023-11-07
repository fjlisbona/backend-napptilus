package com.example.testbackend;

import com.example.testbackend.controller.ProductRequest;
import com.example.testbackend.controller.ProductResponse;
import com.example.testbackend.model.Price;
import com.example.testbackend.repository.ProductRepo;

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
    @Autowired
    private ProductRequest productRequest;
    @Autowired
    private ProductResponse productResponse;

   @Test
    void test1() throws Exception {
        // Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1
        String applyDate = "2020-06-14 10:00:00";
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        productRequest.setProductId(35455);
        productRequest.setChainId(1);
        productRequest.setApplyDate(format.parse(applyDate));
        //Expected response value
        productResponse.setProductId(35455);
        productResponse.setChainId(1);
        productResponse.setPriceList(1);
        productResponse.setApplyDate(format.parse(applyDate));
        productResponse.setTotalPrice(new BigDecimal("35.50"));


        Integer priorityMaxValue = productRepo.getPriorityMaxValue(productRequest);
        Price result = productRepo.findPriceByDate(productRequest, priorityMaxValue);
        assertEquals(result.getPrice(), productResponse.getTotalPrice());


    }

    @Test
    public void test2() throws ParseException {
        //Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1
        productRequest.setProductId(35455);
        productRequest.setChainId(1);
        String applyDate = "2020-06-14 16:00:00";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        productRequest.setProductId(35455);
        productRequest.setChainId(1);
        productRequest.setApplyDate(format.parse(applyDate));
        //Expected response value
        productResponse.setProductId(35455);
        productResponse.setChainId(1);
        productResponse.setPriceList(2);
        productResponse.setApplyDate(format.parse(applyDate));
        productResponse.setTotalPrice(new BigDecimal("25.45"));
        Integer priorityMaxValue = productRepo.getPriorityMaxValue(productRequest);
        Price result = productRepo.findPriceByDate(productRequest, priorityMaxValue);


      assertEquals(result.getPrice(),productResponse.getTotalPrice());


    }

    @Test
    public void test3() throws ParseException {
        //Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1

        productRequest.setProductId(35455);
        productRequest.setChainId(1);
        String applyDate = "2020-06-14 21:00:00";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        productRequest.setProductId(35455);
        productRequest.setChainId(1);
        productRequest.setApplyDate(format.parse(applyDate));
        //Expected response value
        productResponse.setProductId(35455);
        productResponse.setChainId(1);
        productResponse.setPriceList(1);
        productResponse.setApplyDate(format.parse(applyDate));
        productResponse.setTotalPrice(new BigDecimal("35.50"));

        Integer priorityMaxValue = productRepo.getPriorityMaxValue(productRequest);
        Price result = productRepo.findPriceByDate(productRequest, priorityMaxValue);
        assertEquals(result.getPrice(),productResponse.getTotalPrice());
    }

    @Test
    public void test4() throws ParseException {
        //Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1

        productRequest.setProductId(35455);
        productRequest.setChainId(1);
        String applyDate = "2020-06-15 10:00:00";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        productRequest.setProductId(35455);
        productRequest.setChainId(1);
        productRequest.setApplyDate(format.parse(applyDate));
        //Expected response value
        productResponse.setProductId(35455);
        productResponse.setChainId(1);
        productResponse.setPriceList(3);
        productResponse.setApplyDate(format.parse(applyDate));
        productResponse.setTotalPrice(new BigDecimal("30.50"));
        Integer priorityMaxValue = productRepo.getPriorityMaxValue(productRequest);
        Price result = productRepo.findPriceByDate(productRequest, priorityMaxValue);
        assertEquals(result.getPrice(),productResponse.getTotalPrice());

    }

    @Test
    public void test5() throws ParseException {
        //Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1

        productRequest.setProductId(35455);
        productRequest.setChainId(1);
        String applyDate = "2020-06-16 21:00:00";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        productRequest.setProductId(35455);
        productRequest.setChainId(1);
        productRequest.setApplyDate(format.parse(applyDate));
        //Expected response value
        productResponse.setProductId(35455);
        productResponse.setChainId(1);
        productResponse.setPriceList(4);
        productResponse.setApplyDate(format.parse(applyDate));
        productResponse.setTotalPrice(new BigDecimal("38.95"));

        Integer priorityMaxValue = productRepo.getPriorityMaxValue(productRequest);
        Price result = productRepo.findPriceByDate(productRequest, priorityMaxValue);
        assertEquals(result.getPrice(),productResponse.getTotalPrice());
    }
}

