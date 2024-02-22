package com.FirstApp.FirstApp.controller;
import com.FirstApp.FirstApp.global.Roles;
import com.FirstApp.FirstApp.dto.ProductDto;
import com.FirstApp.FirstApp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @PreAuthorize("hasRole('" + Roles.ADMIN + "')")
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){

        ProductDto savedProduct = productService.createProduct(productDto);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('" + Roles.ADMIN + "')")
    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("id") Long productId){

        ProductDto productDto = productService.getProductById(productId);
        return ResponseEntity.ok(productDto);
    }

    @PreAuthorize("hasRole('" + Roles.ADMIN + "')")
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){

      List<ProductDto> products = productService.getAllProducts();
      return ResponseEntity.ok(products);
    }

    @PreAuthorize("hasRole('" + Roles.ADMIN + "')")
    @PutMapping("{id}")
    public ResponseEntity<ProductDto> updateProduct(
            @PathVariable("id") Long productId,
            @RequestBody ProductDto updatedProduct){
        ProductDto productDto = productService.updateProduct(productId ,updatedProduct);

        return ResponseEntity.ok(productDto);
    }

    @PreAuthorize("hasRole('" + Roles.ADMIN + "')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long productId){
        productService.deleteProduct(productId);
        return ResponseEntity.ok("Product deleted successfully!.");
    }
}
