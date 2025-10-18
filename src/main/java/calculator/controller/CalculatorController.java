package controller;

import main.java.calculator.model.Calculator;
import view.InputView;

public class CalculatorController {
    public void run() {
        String inputText = InputView.getInputString();
        Calculator calculator = new Calculator();
        calculator.processInput(inputText);
    }
}