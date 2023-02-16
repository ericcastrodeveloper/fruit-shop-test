package com.aisatec.fruitshoptest.service;

import com.aisatec.fruitshoptest.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAll();
    Optional<Product> getById(Long id);
    Optional<Product> getByName(String name);
    Product save(Product product);
    Optional<Product> update(Long id, Product product);
    boolean delete(Long id);
}
