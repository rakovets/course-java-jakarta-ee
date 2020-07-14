package com.rakovets.course_java_enterprise.solution;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(12, calculator.add(2, 10));
        assertEquals(3.25, calculator.add(-2.3, 5.55));
    }

    @Test
    public void testSubtract() {
        assertEquals(14, calculator.subtract(20, 6));
        assertEquals(12.5, calculator.subtract(14, 1.5));
    }

    @Test
    public void testMultiply() {
        assertEquals(12.5, calculator.multiply(5, 2.5));
        assertEquals(13.2, calculator.multiply(3.3, 4));
    }

    @Test
    public void testDivide() {
        assertEquals(36.25, calculator.divide(145, 4));
        assertEquals(2.8, calculator.divide(14, 5));
    }
}
