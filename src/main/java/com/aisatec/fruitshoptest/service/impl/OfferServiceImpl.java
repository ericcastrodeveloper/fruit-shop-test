package com.aisatec.fruitshoptest.service.impl;

import com.aisatec.fruitshoptest.domain.Order;
import com.aisatec.fruitshoptest.domain.OrderLine;
import com.aisatec.fruitshoptest.service.OfferService;
import com.aisatec.fruitshoptest.strategy.AppleOfferStrategy;
import com.aisatec.fruitshoptest.strategy.PearlOfferStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class OfferServiceImpl implements OfferService {
    private AppleOfferStrategy appleOfferStrategy;
    private PearlOfferStrategy pearlOfferStrategy;

    public OfferServiceImpl(AppleOfferStrategy appleOfferStrategy, PearlOfferStrategy pearlOfferStrategy) {
        this.appleOfferStrategy = appleOfferStrategy;
        this.pearlOfferStrategy = pearlOfferStrategy;
    }

    @Override
    public void applyOffer(Order order) {
        List<OrderLine> list = new CopyOnWriteArrayList(order.getOrderLines());
        list.forEach(ol -> {
            if(ol.getProduct().getName().equals("Apple"))
                appleOfferStrategy.apply(order, ol);
            if(ol.getProduct().getName().equals("Pear"))
                pearlOfferStrategy.apply(order, ol);
        });
        order.setOrderLines(list);
    }
}
