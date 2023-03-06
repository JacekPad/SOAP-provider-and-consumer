package com.soapTutorial.consumer.controller;

import com.soapTutorial.consumer.model.GetProductResponse;
import com.soapTutorial.consumer.model.Product;
import com.soapTutorial.consumer.service.ProductConsumer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private ProductConsumer productConsumer;

    public ProductController (ProductConsumer consumer) {
        this.productConsumer = consumer;
    }


    @GetMapping("/")
    public Product getProduct() {
        GetProductResponse response = productConsumer.getProduct(1);
        return response.getProduct();
    }
}
