package com.svuyyuru.Calculator.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.svuyyuru.Calculator.models.Input;
import com.svuyyuru.Calculator.services.Calculator;


@RestController
public class MainController {
    
    @Autowired
    Calculator calculator;

    @RequestMapping("calculate")
    public String getc(@RequestBody Input input) {
        List<Integer> factorials = input.getFactorials();
        String equation = input.getEquation();
        
        return calculator.calculate(equation, factorials);
    }
    
}
