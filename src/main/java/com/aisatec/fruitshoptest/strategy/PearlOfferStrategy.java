package com.aisatec.fruitshoptest.strategy;

import com.aisatec.fruitshoptest.domain.Order;
import com.aisatec.fruitshoptest.domain.OrderLine;
import com.aisatec.fruitshoptest.domain.Product;
import com.aisatec.fruitshoptest.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class PearlOfferStrategy implements OfferStrategy {

    private ProductServiceImpl productService;

    public PearlOfferStrategy(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @Override
    public void apply(Order order, OrderLine orderLine) {
        getFreeOrangeForEveryTwoPearls(order, orderLine);
        getOneEuroDiscounForEveryFourEuroSpent(order, orderLine);
    }


    private void getFreeOrangeForEveryTwoPearls(Order order, OrderLine orderLine) {
        BigDecimal amountOranges = orderLine.getAmount().divide(BigDecimal.valueOf(2));
        if (amountOranges.compareTo(BigDecimal.valueOf(2)) >= 0) {
            OrderLine orangeOrderLine = createOrangeOrderLine(order);
            for (int i = 0; i < amountOranges.intValue(); i++) {
                 addOrange(orangeOrderLine);
            }

        }

    }

    private void addOrange(OrderLine orangeOrderLine) {
         orangeOrderLine.setAmount(orangeOrderLine.getAmount().add(BigDecimal.ONE));
    }

    private OrderLine createOrangeOrderLine(Order order) {
        //get orange from database
        Optional<Product> orange = productService.getByName("Orange");

        OrderLine orderLineOrange = new OrderLine();
        orderLineOrange.setProduct(orange.get());
        orderLineOrange.setAmount(BigDecimal.ZERO);
        orderLineOrange.setPrice(BigDecimal.ZERO);
        List<OrderLine> orderLines = order.getOrderLines();
        orderLines.add(orderLineOrange);
        orderLineOrange.setOrder(order);
        return orderLineOrange;
    }

    private void getOneEuroDiscounForEveryFourEuroSpent(Order order, OrderLine orderLine) {
        BigDecimal totalAmount = order.getTotalAmount();
        int totalAmountPears = orderLine.getPrice().divide(BigDecimal.valueOf(4)).intValue();
        order.setTotalAmount(totalAmount.subtract(BigDecimal.valueOf(totalAmountPears)));
        orderLine.setOrder(order);
    }
}
