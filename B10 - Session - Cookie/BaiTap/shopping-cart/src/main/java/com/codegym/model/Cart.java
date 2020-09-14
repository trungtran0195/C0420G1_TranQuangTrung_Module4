package com.codegym.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> cart;

    public Cart(){
        cart = new HashMap<>();
    }

    public void addToCart(Product product){
        if (cart.containsKey(product)){
            cart.replace(product,cart.get(product),cart.get(product)+1);
        }else
            cart.put(product,1);
    }

    public void removeCart(Product product){
        cart.remove(product);
    }
    public int amount(Product product){
        return cart.get(product);
    }
    public Map<Product,Integer> getCart(){
        return cart;
    }
    public void sub(Product product){
        if(cart.containsKey(product)){
            cart.replace(product,cart.get(product),cart.get(product)-1);
        }
        if(cart.get(product)==0){
            cart.remove(product);
        }
    }
}
