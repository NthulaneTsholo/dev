package co.za.calculator.calculator.dao;

import co.za.calculator.calculator.entities.Calculator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculatorDAO  extends JpaRepository<Calculator, Long> {
}
