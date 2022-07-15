package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService{
    @Override
    public String calculator(String number1, String number2, char check) {
        String a = "";
        try{
            double input1 = Double.parseDouble(number1);
            double input2 = Double.parseDouble(number2);
            switch (check){
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
                    if (input2 == 0){
                        a += " khong chia duoc";
                    }else {
                        a += input1 / input2;
                    }
                    break;
            }

        }catch (NumberFormatException e){
            a += "NumberFormatException";
        }
        return a;
    }
}
