package com.example.productmanagement.controller;

import com.example.productmanagement.entity.Product;
import com.example.productmanagement.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        List<Product> productList = productService.getAllProducts();
        log.info("List product will be returned {}", productList.toArray().toString());
        return productList;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        log.info("Product {} will be created", product.toString());
        return productService.saveProduct(product);
    }
}
