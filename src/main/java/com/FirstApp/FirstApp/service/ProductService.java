package com.FirstApp.FirstApp.service;
import com.FirstApp.FirstApp.dto.ProductDto;
import java.util.List;


public interface ProductService {
     ProductDto createProduct(ProductDto productDto);
     ProductDto getProductById(Long productId);
     List<ProductDto> getAllProducts();
     ProductDto updateProduct(Long productId, ProductDto updatedProduct);
     void deleteProduct(Long productId);
}
