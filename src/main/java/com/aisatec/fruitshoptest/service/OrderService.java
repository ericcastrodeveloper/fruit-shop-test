package com.aisatec.fruitshoptest.service;

import com.aisatec.fruitshoptest.domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getAll();
    Optional<Order> getById(Long id);
    Order save(Order order);
    boolean delete(Long id);
}
