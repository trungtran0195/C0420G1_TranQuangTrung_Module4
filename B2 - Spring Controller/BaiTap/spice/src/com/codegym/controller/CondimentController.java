package com.codegym.controller;


import com.codegym.model.Condiment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class CondimentController {

    private Condiment condiment = new Condiment();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("condiment", condiment);
        return "input";
    }

    @RequestMapping("/addCondiment")
    public String add(@RequestParam(value = "condiment",required = false) String[] condiment, Model model) {
        model.addAttribute("result",condiment);
        return "save";
    }


}