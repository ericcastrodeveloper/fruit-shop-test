package com.aisatec.fruitshoptest.mapper;

import com.aisatec.fruitshoptest.domain.Order;
import com.aisatec.fruitshoptest.domain.Product;
import com.aisatec.fruitshoptest.dto.OrderDTO;
import com.aisatec.fruitshoptest.dto.ProductDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDTO domainToDTO(Order order);
    Order DTOToDomain(OrderDTO orderDTO);
    List<OrderDTO> domainListToDTOList(List<Order> orders);
    List<Order> DTOListToDomainList(List<OrderDTO> orderDTOS);
}
