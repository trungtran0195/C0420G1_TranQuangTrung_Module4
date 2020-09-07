package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.model.ShoppingCart;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@SessionAttributes("cart")
public class ShoppingCartController {

    @Autowired
    private ProductService productService;

    @GetMapping("/shop")
    public ModelAndView listProduct(){
        List<Product> products = productService.findAll();
        if (products.isEmpty()) {
            return new ModelAndView("freshshop/shop", "message", "Không tìm thấy sản phẩm nào");
        } else {
            ModelAndView modelAndView = new ModelAndView("freshshop/shop");
            modelAndView.addObject("products", products);
            return modelAndView;
        }
    }

    @GetMapping("/detail-product/{id}")
    public ModelAndView showProduct(@PathVariable Integer id){
        Product product = productService.findById(id);
        if(product != null) {
            ModelAndView modelAndView = new ModelAndView("freshshop/shop");
            modelAndView.addObject("product", product);
            return modelAndView;
        }else {
            return new ModelAndView("listProduct", "message", "Không tìm thấy sản phẩm nào");
        }
    }

    @GetMapping("/add-cart/{id}")
    public ModelAndView addCart(@PathVariable Integer id, @SessionAttribute("cart") ShoppingCart shoppingCart){
        Product product = productService.findById(id);
        shoppingCart.addProduct(product,1);
        ModelAndView modelAndView = new ModelAndView("listProduct","message", "Đã thêm mới sản phẩm vào giỏ");
        return modelAndView;
    }

    @ModelAttribute("cart")
    public ShoppingCart shoppingCart(){
        return shoppingCart();
    }
}
