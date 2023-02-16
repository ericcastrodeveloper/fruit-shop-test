package com.aisatec.fruitshoptest.controller;

import com.aisatec.fruitshoptest.domain.Product;
import com.aisatec.fruitshoptest.dto.ProductDTO;
import com.aisatec.fruitshoptest.mapper.ProductMapper;
import com.aisatec.fruitshoptest.service.impl.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductServiceImpl service;
    private ProductMapper mapper;

    public ProductController(ProductServiceImpl service, ProductMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll() {
        return ResponseEntity.ok(mapper.domainListToDTOList(service.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable Long id) {
        Optional<Product> response = service.getById(id);
        return response.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(mapper.domainToDTO(response.get()));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO) {
        Product response = service.save(mapper.DTOToDomain(productDTO));
        return new ResponseEntity<>(mapper.domainToDTO(response), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO product) {
        Optional<Product> response = service.update(id, mapper.DTOToDomain(product));
        return response.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(mapper.domainToDTO(response.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        boolean response = service.delete(id);
        return response ? ResponseEntity.ok().build() : ResponseEntity.noContent().build();
    }

}
