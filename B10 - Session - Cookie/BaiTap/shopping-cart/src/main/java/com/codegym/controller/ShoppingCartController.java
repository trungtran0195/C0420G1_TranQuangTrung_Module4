package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.model.Cart;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@SessionAttributes("cart")
public class ShoppingCartController {
    @ModelAttribute("cart")
    public Cart cart(){
        return new Cart();
    }

    @Autowired
    private ProductService productService;

    @GetMapping("/shop")
    public ModelAndView listProduct(){
        List<Product> products = productService.findAll();
        if (products.isEmpty()) {
            return new ModelAndView("listProduct", "message", "Không tìm thấy sản phẩm nào");
        } else {
            ModelAndView modelAndView = new ModelAndView("listProduct");
            modelAndView.addObject("products", products);
            return modelAndView;
        }
    }

    @GetMapping("/product/{id}/view")
    public ModelAndView showProduct(@PathVariable Integer id){
        Product product = productService.findById(id);
        if(product != null) {
            ModelAndView modelAndView = new ModelAndView("view");
            modelAndView.addObject("product", product);
            return modelAndView;
        }else {
            return new ModelAndView("listProduct", "message", "Không tìm thấy sản phẩm nào");
        }
    }

    @PostMapping("/add-cart")
    public ModelAndView addCart(@RequestParam Integer id, @SessionAttribute("cart") Cart cart){
        Product product = productService.findById(id);
        if (product==null){
            ModelAndView modelAndView = new ModelAndView ("listProduct","message","error");
            return modelAndView;
        }else {
            cart.addToCart(product);
            ModelAndView modelAndView = new ModelAndView("listProduct", "message", "Đã thêm mới sản phẩm vào giỏ");
            return modelAndView;
        }
    }

    @GetMapping("/cart")
    public ModelAndView getCart(@SessionAttribute("cart") Cart cart){
        return new ModelAndView("cart","carts",cart.getCart());
    }

    @GetMapping("/cart/{id}/add")
    public String amountCart(@PathVariable int id, @SessionAttribute("cart")Cart cart, Model model){
        Product product = productService.findById(id);
        cart.addToCart(product);
        model.addAttribute("carts",cart.getCart());
        return "cart";
    }
    @GetMapping("/cart/{id}/sub")
    public String amountCartSub(@PathVariable int id,@SessionAttribute("cart")Cart cart,Model model){
        Product product = productService.findById(id);
        cart.sub(product);
        model.addAttribute("carts",cart.getCart());
        return "cart";
    }

}
