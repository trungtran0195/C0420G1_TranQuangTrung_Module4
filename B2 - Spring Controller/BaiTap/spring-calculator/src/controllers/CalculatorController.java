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
    public String inputCalculator(@RequestParam("number1") Double numberA,@RequestParam("number2") Double numberB,@RequestParam("calculate") String calculate, Model model) {

        double result = sumService.sum(numberA,numberB,calculate);
        if (calculate.equals("Division(/)") && numberB == 0){
            model.addAttribute("calculateNumberAB", "khong the thuc hien phep tinh nay");
        }else
            model.addAttribute("calculateNumberAB", result);

        return "index";
    }
}
