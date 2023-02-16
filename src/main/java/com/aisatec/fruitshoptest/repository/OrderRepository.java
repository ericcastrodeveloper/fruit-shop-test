package com.aisatec.fruitshoptest.repository;

import com.aisatec.fruitshoptest.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
