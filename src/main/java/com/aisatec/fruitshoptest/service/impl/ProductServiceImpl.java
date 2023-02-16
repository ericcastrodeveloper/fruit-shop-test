package com.aisatec.fruitshoptest.service.impl;

import com.aisatec.fruitshoptest.domain.Product;
import com.aisatec.fruitshoptest.repository.ProductRepository;
import com.aisatec.fruitshoptest.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Optional<Product> getById(Long id) {
        return repository.findById(id);
    }

    public Optional<Product> getByName(String name) {
        return repository.findByName(name);
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public Optional<Product> update(Long id, Product product) {
        Optional<Product> saved = repository.findById(id);
        if (saved.isPresent()) {
            saved.get().setName(product.getName());
            saved.get().setPrice(product.getPrice());
            return Optional.of(repository.save(saved.get()));
        } else
            return Optional.empty();

    }

    public boolean delete(Long id) {
        Optional<Product> saved = repository.findById(id);
        if (saved.isEmpty())
            return false;

        repository.delete(saved.get());

        return true;
    }
}
