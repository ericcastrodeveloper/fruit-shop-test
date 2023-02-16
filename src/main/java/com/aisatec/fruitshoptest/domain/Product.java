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
@Table(name = "TB_PRODUCTS")
@Entity
public class Product {
    @Id
    @SequenceGenerator(name = "products_id_seq", initialValue = 4)
    @GeneratedValue(generator = "products_id_seq")
    private Long id;
    private String name;
    private BigDecimal price;
}
