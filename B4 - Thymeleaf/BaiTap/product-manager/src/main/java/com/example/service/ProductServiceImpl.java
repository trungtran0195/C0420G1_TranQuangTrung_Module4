package com.example.service;

import com.example.model.Product;

import java.util.ArrayList;

public class ProductServiceImpl implements ProductService {
    private static ArrayList<Product> productList;

    static{
        productList = new ArrayList<>();
        productList.add(new Product(1, "Iphone 8", 10000000,"Apple", "China"));
        productList.add(new Product(2, "Iphone X", 15000000,"Apple", "China"));
        productList.add(new Product(3, "Note 12", 15000000,"Samsung", "VietNam"));
        productList.add(new Product(4, "Galaxy S12", 10000000,"Samsung", "VietNam"));
    }


    @Override
    public ArrayList<Product> findAll() {
        return new ArrayList<Product>(productList);
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        int i;
        for (i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                return productList.get(i);
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        int i;
        for (i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.add(i,product);
            }
        }
    }

    @Override
    public void remove(int id) {
        int i;
        for (i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(i);
            }
        }
    }
}
