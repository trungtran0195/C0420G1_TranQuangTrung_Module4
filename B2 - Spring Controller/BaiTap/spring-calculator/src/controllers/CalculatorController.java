package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.SumService;

@Controller
public class CalculatorController {

    @Autowired
    private SumService sumService;

    @GetMapping("")
    public String index(){
        return "index";
    }

    @GetMapping("/sum")
//    @PostMapping("/sum")
    public String abc(@RequestParam("number1") String numberA,@RequestParam("number2") String numberB,@RequestParam("calculate") String calculate, Model model) {

        double result = sumService.sum(Double.parseDouble(numberA),Double.parseDouble(numberB),calculate);
        if ("Division(/)".equals(calculate) && Double.parseDouble(numberB) == 0){
            model.addAttribute("sumNum12", "khong the thuc hien phep tinh nay");
        }else
            model.addAttribute("sumNum12", result);

        return "index";
    }
}
