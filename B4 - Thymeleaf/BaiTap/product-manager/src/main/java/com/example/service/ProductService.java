package com.example.service;

import com.example.model.Product;

import java.util.ArrayList;

public interface ProductService {
    ArrayList<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);
}
