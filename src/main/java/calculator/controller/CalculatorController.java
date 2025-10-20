package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import java.util.List;

public class CalculatorController {
    public void run() {
        String inputText = InputView.getInputString();

        Calculator calculator = new Calculator();
        List<Integer> extractedNumbers = calculator.extractNumbers(inputText);
    }
}