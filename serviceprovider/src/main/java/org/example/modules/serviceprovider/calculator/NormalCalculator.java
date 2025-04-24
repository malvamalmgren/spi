package org.example.modules.serviceprovider.calculator;

import org.example.modules.service.calculator.Calculator;

public class NormalCalculator implements Calculator {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
