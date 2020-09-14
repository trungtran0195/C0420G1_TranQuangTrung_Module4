package com.codegym.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String productName;

    private String productPrice;

    private String productImage;

    private String productDetail;

    public Product() {
    }

    public Product(int id, String productName, String productPrice, String productImage, String productDetail) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.productDetail = productDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                productPrice == product.productPrice &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(productDetail, product.productDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, productDetail, productPrice);
    }

}
