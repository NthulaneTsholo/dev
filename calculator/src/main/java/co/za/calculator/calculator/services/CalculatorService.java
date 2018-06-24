package co.za.calculator.calculator.services;

import co.za.calculator.calculator.entities.Calculator;

import java.util.List;

public interface CalculatorService {

    double add(double num1, double num2);
    double subtract(double num1, double num2);
    double multiply(double num1, double num2);
    double divide(double num1, double num2);

    Calculator addCalculation(Calculator calculator);
    void delete(Long id);
    Calculator findCalculator(Long id);
    List<Calculator> findAll();
}
