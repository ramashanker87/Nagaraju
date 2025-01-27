package com.naga.app;

import org.junit.Test;

public class CalculatorTest {
@Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        double result=calculator.add(2,4);
        assert result==6;
    }
    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        double result = calculator.subtract(7,5);
        assert result==2;
    }
    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        double result= calculator.multiply(2,4);
        assert result==8;
    }

}
