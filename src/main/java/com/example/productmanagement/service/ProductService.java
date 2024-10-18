package com.example.productmanagement.service;

import com.example.productmanagement.entity.Product;
import com.example.productmanagement.kafka.ProductKafkaProducer;
import com.example.productmanagement.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductKafkaProducer kafkaProducer;

    public ProductService(ProductRepository productRepository, ProductKafkaProducer kafkaProducer) {
        this.productRepository = productRepository;
        this.kafkaProducer = kafkaProducer;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        Product savedProduct = productRepository.save(product);
//        kafkaProducer.sendMessage("Created Product: " + savedProduct.getName());
        return savedProduct;
    }
}
