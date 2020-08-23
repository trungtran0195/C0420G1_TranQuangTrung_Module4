package service.impl;

import org.springframework.stereotype.Service;
import service.SumService;

@Service
public class SumServiceImpl implements SumService {

    @Override
    public double sum(double num1, double num2, String calculate) {
        double result;
        switch (calculate){
            case "Addition(+)":
                result = num1 + num2;
                break;
            case "Subtraction(-)":
                result = num1 - num2;
                break;
            case "Multiplication(x)":
                result = num1 * num2;
                break;
            case "Division(/)":
                if (num2 != 0){
                    result = num1 / num2;
                }else {
                    result = 0;
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + calculate);
        }
        return result;
    }
}
