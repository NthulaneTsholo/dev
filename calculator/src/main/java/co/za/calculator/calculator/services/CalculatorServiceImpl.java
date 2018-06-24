package co.za.calculator.calculator.services;


import co.za.calculator.calculator.dao.CalculatorDAO;
import co.za.calculator.calculator.entities.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    private static final String ADD = "Addition";
    private static final String SUBTRACT = "Subtraction";
    private static final String MULTIPLY = "Multiplication";
    private static final String DIVIDE = "Division";

    @Autowired
    private CalculatorDAO calculatorDAO;

    @Override
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    @Override
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public double divide(double num1, double num2) {
        return num1 / num2;
    }

    @Override
    public Calculator addCalculation(Calculator calculator) {
        double answer = add(calculator.getNum1(), calculator.getNum2());
        calculator.setAnswer(answer);
        calculator.setTimeStamp(new Date().toString());
        calculator.setUser("Tsholo");
        calculator.setCalculationRequested(ADD);
        return calculatorDAO.save(calculator);
    }

    @Override
    public void delete(Long id) {
        Calculator calculator = findCalculator(id);
        if(calculator != null){
            calculatorDAO.deleteById(id);
        }
    }

    @Override
    public Calculator findCalculator(Long id) {
        return calculatorDAO.getOne(id);
    }

    @Override
    public List<Calculator> findAll() {
        return calculatorDAO.findAll();
    }
}
