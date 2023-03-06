package com.soap.tutorial.mappers;

import com.soap.tutorial.model.Product.Product;
import com.soap.tutorial.model.Products;
import org.springframework.stereotype.Component;

@Component
public class SOAPResponseMapper {

    public Product mapToResponseProduct(Products entity) {
        Product product = new Product();
        product.setId(entity.getId());
        product.setName(entity.getName());
        product.setType(entity.getType());
        product.setQuantity(entity.getQuantity());
        product.setPrice(entity.getPrice());
        return product;
    }
}
