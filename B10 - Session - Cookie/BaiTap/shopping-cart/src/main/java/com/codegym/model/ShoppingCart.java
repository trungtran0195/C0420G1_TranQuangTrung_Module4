package com.codegym.model;

import java.util.List;

public class ShoppingCart {
    private List<CartItem> shoppingCart;

    public ShoppingCart() {
    }

    public List<CartItem> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(List<CartItem> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void addProduct(Product product,int quantity){
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        this.shoppingCart.add(cartItem);
    }
}
