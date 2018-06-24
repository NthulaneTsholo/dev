package co.za.calculator.calculator.controllers;

import co.za.calculator.calculator.entities.Calculator;
import co.za.calculator.calculator.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping(value = "/add-operation", method = RequestMethod.GET)
    public String viewAddCalculation(Model modelMap){
        modelMap.addAttribute("calculator", new Calculator());
        return "add";
    }

    @RequestMapping(value = "/add-operation", method = RequestMethod.POST)
    public String addCalculation(Calculator calculator, ModelMap modelMap){
        Calculator dbCalculator = calculatorService.addCalculation(calculator);
        modelMap.addAttribute("calculator", dbCalculator);
        return "answer";
    }

    @DeleteMapping(value = "{id}")
    public String deleteCalculation(@PathVariable Long id, ModelMap modelMap){
        calculatorService.delete(id);
        return "delete";
    }

    @GetMapping(value = "{id}")
    public String findOne(@PathVariable Long id, ModelMap modelMap){
        calculatorService.findCalculator(id);
        return "findone";
    }

    @GetMapping
    public String getAll(ModelMap modelMap) {
       calculatorService.findAll();
       return "getall";
    }

    @InitBinder
    private void initBinder(WebDataBinder webDataBinder){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, false));
    }
}
