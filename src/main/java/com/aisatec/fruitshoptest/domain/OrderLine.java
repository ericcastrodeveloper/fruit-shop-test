package com.aisatec.fruitshoptest.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_ORDER_LINES")
@Entity
public class OrderLine {
    @Id
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false, insertable = false)
    private Order order;
    @Id
    @ManyToOne(optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false)
    private Product product;
    private BigDecimal amount;
    private BigDecimal price;
}
