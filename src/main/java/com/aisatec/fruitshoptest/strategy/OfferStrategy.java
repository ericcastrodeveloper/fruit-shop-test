package com.aisatec.fruitshoptest.strategy;

import com.aisatec.fruitshoptest.domain.Order;
import com.aisatec.fruitshoptest.domain.OrderLine;

public interface OfferStrategy {
    void apply(Order order, OrderLine orderLine);
}
