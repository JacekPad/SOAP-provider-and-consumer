package com.soap.tutorial.service;

import com.soap.tutorial.model.Products;
import com.soap.tutorial.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    private final ProductsRepository repository;

    public ProductsService(ProductsRepository repository) {
        this.repository = repository;
    }

    public List<Products> getProducts() {
        return repository.findAll();
    }

    public Products getProducts(Long id) {
        return repository.findById(id).get();
    }

}
