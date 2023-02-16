package com.aisatec.fruitshoptest.service.impl;

import com.aisatec.fruitshoptest.domain.Order;
import com.aisatec.fruitshoptest.repository.OrderRepository;
import com.aisatec.fruitshoptest.service.OfferService;
import com.aisatec.fruitshoptest.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository repository;
    private OfferService offerService;

    public OrderServiceImpl(OrderRepository repository, OfferService offerService) {
        this.repository = repository;
        this.offerService = offerService;
    }

    public List<Order> getAll() {
        return repository.findAll();
    }

    public Optional<Order> getById(Long id) {
        return repository.findById(id);
    }

    public Order save(Order order) {
        order.getOrderLines().forEach(orderLine -> orderLine.setOrder(order));
        offerService.applyOffer(order);
        return repository.save(order);
    }


    public boolean delete(Long id) {
        Optional<Order> saved = repository.findById(id);
        if (saved.isEmpty())
            return false;

        repository.delete(saved.get());

        return true;
    }
}
