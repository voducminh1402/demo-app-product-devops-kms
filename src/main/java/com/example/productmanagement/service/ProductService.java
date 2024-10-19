package com.example.productmanagement.service;

import com.example.productmanagement.entity.Product;
import com.example.productmanagement.kafka.ProductKafkaProducer;
import com.example.productmanagement.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final SqsMessageSender sqsMessageSender;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        sqsMessageSender.sendMessage(savedProduct.toString());
        return savedProduct;
    }
}
