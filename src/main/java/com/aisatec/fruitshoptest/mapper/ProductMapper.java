package com.aisatec.fruitshoptest.mapper;

import com.aisatec.fruitshoptest.domain.Product;
import com.aisatec.fruitshoptest.dto.ProductDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO domainToDTO(Product product);
    Product DTOToDomain(ProductDTO productDTO);
    List<ProductDTO> domainListToDTOList(List<Product> products);
    List<Product> DTOListToDomainList(List<ProductDTO> productDTOS);
}
