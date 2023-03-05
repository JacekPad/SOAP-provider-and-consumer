package com.soap.tutorial.service;

import com.soap.tutorial.model.Product.GetProductRequest;
import com.soap.tutorial.model.Product.GetProductResponse;
import com.soap.tutorial.model.Product.Product;
import com.soap.tutorial.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ProductEndpoint {
    private ProductsService service;

    @Autowired
    public ProductEndpoint(ProductsService service) {
        this.service = service;
    }

    @PayloadRoot(namespace = "com/soap/tutorial/products", localPart = "getProductRequest")
    @ResponsePayload
    public GetProductResponse getProductResponse(@RequestPayload GetProductRequest request) {
        long id = request.getId();
        Products products = service.getProducts(id);
        GetProductResponse response = new GetProductResponse();
        Product product = mapProducts(products);
        response.setProduct(product);
        return response;
    }

    private Product mapProducts(Products dbProduct) {
        Product product = new Product();
        product.setId(dbProduct.getId());
        product.setName(dbProduct.getName());
        product.setType(dbProduct.getType());
        product.setQuantity(dbProduct.getQuantity());
        product.setPrice(dbProduct.getPrice());
        return product;
    }
}
