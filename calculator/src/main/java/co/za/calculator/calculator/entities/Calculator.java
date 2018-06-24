package co.za.calculator.calculator.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Calculator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String calculationRequested;
    private String user;
    private String timeStamp;
    private double answer;

    @Transient
    private double num1;

    @Transient
    private double num2;

    public Calculator() {
    }

    public double getAnswer() {
        return answer;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalculationRequested() {
        return calculationRequested;
    }

    public void setCalculationRequested(String calculationRequested) {
        this.calculationRequested = calculationRequested;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculator that = (Calculator) o;
        return Double.compare(that.answer, answer) == 0 &&
                Double.compare(that.num1, num1) == 0 &&
                Double.compare(that.num2, num2) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(calculationRequested, that.calculationRequested) &&
                Objects.equals(user, that.user) &&
                Objects.equals(timeStamp, that.timeStamp);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, calculationRequested, user, timeStamp, answer, num1, num2);
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "id=" + id +
                ", calculationRequested='" + calculationRequested + '\'' +
                ", user='" + user + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", answer=" + answer +
                ", num1=" + num1 +
                ", num2=" + num2 +
                '}';
    }
}
