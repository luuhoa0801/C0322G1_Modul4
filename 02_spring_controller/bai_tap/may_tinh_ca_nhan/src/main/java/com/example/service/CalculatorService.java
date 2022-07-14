package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public String calculator(String number1, String number2, char check) {
        String a = "";
        try {
            Double input1 = Double.parseDouble(number1);
            Double input2 = Double.parseDouble(number2);
            switch (check) {
                case '+':
                    a += input1 + input2;
                    break;
                case '-':
                    a += input1 - input2;
                    break;
                case '*':
                    a += input1 * input2;
                    break;
                case '/':
                    if (input2 != 0) {
                        a += input1 / input2;
                    } else {
                        a += "không chia được";
                    }
                    break;
            }
        } catch (NumberFormatException e) {
            a += "NumberFormatException";
        }
        return a;
    }
}

