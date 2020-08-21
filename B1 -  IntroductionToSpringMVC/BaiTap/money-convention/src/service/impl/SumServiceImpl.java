package service.impl;

import org.springframework.stereotype.Service;
import service.SumService;

@Service
public class SumServiceImpl implements SumService {

    @Override
    public double sum(double num1) {
        return num1 *22000;
    }
}
