package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.SumService;

@Controller
public class ConverMoneyController {

    @Autowired
    private SumService sumService;

    @GetMapping("/index")
    public String greeting(){
        return "index";
    }

    @GetMapping("/sum")
//    @PostMapping("/sum")
    public String abc(@RequestParam("number1") String numberA, Model model) {

        double result = sumService.sum(Double.parseDouble(numberA));
        model.addAttribute("sumNum12", result);

        return "index";
    }
}
