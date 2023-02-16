package com.aisatec.fruitshoptest.controller;

import com.aisatec.fruitshoptest.domain.Order;
import com.aisatec.fruitshoptest.dto.OrderDTO;
import com.aisatec.fruitshoptest.mapper.OrderMapper;
import com.aisatec.fruitshoptest.service.impl.OrderServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderServiceImpl service;
    private OrderMapper mapper;

    public OrderController(OrderServiceImpl service, OrderMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAll() {
        return ResponseEntity.ok(mapper.domainListToDTOList(service.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getById(@PathVariable Long id) {
        Optional<Order> response = service.getById(id);
        return response.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(mapper.domainToDTO(response.get()));
    }

    @PostMapping
    public ResponseEntity<OrderDTO> save(@RequestBody OrderDTO orderDTO) {
        Order response = service.save(mapper.DTOToDomain(orderDTO));
        return new ResponseEntity(mapper.domainToDTO(response), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        boolean response = service.delete(id);
        return response ? ResponseEntity.ok().build() : ResponseEntity.noContent().build();
    }
}
