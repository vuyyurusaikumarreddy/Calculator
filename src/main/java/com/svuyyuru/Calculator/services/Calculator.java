package com.svuyyuru.Calculator.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fathzer.soft.javaluator.DoubleEvaluator;


@Service
public class Calculator {

    DoubleEvaluator eval = new DoubleEvaluator();

    public String calculate(String equation, List<Integer> factorials) {
        
        String replacedString = equation;
        for(int i=0;i<factorials.size();i++){
            for(int j = 0; j<= replacedString.length();j++){
                int k = replacedString.charAt(j);
                if(97<=k && k<=122){
                    replacedString = replacedString.replaceFirst(String.valueOf(replacedString.charAt(j)), String.valueOf(calculateFactorial(factorials.get(i))));
                    break;
                }
            }
        }
        
        
 
        Double result = eval.evaluate(replacedString);

        return "result is :" + new BigDecimal(result).toPlainString();
        
    }

    private double calculateFactorial(int n) {
        Double fact = 1.0;
        for(int i=n;i>0;i--){
            fact = fact * i;
        }

        return eval.evaluate(String.valueOf(fact));
    }
    
}
