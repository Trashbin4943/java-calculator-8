package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {
    public void run() {
        String inputText = InputView.getInputString();

        Calculator calculator = new Calculator();
        int result = calculator.add(inputText);

        OutputView.printResult(result);
    }
}