package com.FirstApp.FirstApp.mapper;
import com.FirstApp.FirstApp.dto.ProductDto;
import com.FirstApp.FirstApp.entity.Product;

public class ProductMapper {

    public static ProductDto mapToProductDto(Product product){
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getCreated()
        );
    }

    public static Product mapToProduct(ProductDto productDto){
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getPrice(),
                productDto.getCreated()
        );
    }

}
