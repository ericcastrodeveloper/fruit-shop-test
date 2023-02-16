package com.aisatec.fruitshoptest.strategy;

import com.aisatec.fruitshoptest.domain.Order;
import com.aisatec.fruitshoptest.domain.OrderLine;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AppleOfferStrategy implements OfferStrategy {

    @Override
    public void apply(Order order, OrderLine orderLine) {
        if(orderLine.getAmount().intValue() == 3){
            orderLine.getOrder().setTotalAmount(orderLine.getOrder().getTotalAmount().subtract(orderLine.getProduct().getPrice()));
        }
    }
}
