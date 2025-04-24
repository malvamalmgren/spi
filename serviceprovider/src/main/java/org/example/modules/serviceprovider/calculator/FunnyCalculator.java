package org.example.modules.serviceprovider.calculator;

import org.example.modules.service.calculator.Calculator;

public class FunnyCalculator implements Calculator {

    //implement methods eller gör Calculator abstrakt
    @Override
    public int add(int a, int b) {
        return (int) (Math.random() * 1000);
    }
}
