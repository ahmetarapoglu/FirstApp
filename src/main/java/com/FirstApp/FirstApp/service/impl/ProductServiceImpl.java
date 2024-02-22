package com.FirstApp.FirstApp.service.impl;
import com.FirstApp.FirstApp.dto.ProductDto;
import com.FirstApp.FirstApp.entity.Product;
import com.FirstApp.FirstApp.exception.ResourceNotFoundException;
import com.FirstApp.FirstApp.mapper.ProductMapper;
import com.FirstApp.FirstApp.repository.ProductRepository;
import com.FirstApp.FirstApp.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {

        Product product = ProductMapper.mapToProduct(productDto);

        Product savedProduct =  productRepository.save(product);

        return ProductMapper.mapToProductDto(savedProduct);
    }

    @Override
    public ProductDto getProductById(Long productId) {
        Product product =  productRepository.findById(productId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product Not exists With given id." + productId));

        return ProductMapper.mapToProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(ProductMapper::mapToProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(Long productId, ProductDto updatedProduct) {

        Product product =  productRepository.findById(productId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product Not exists With given id." +productId));

        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());

        Product updatedProductObj = productRepository.save(product);

        return ProductMapper.mapToProductDto(updatedProductObj);
    }

    @Override
    public void deleteProduct(Long productId) {

        Product product =  productRepository.findById(productId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product Not exists With given id." + productId));

        productRepository.deleteById(productId);
    }

}
