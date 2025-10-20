package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {
    public void run() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Calculator calculator = new Calculator();

        try {
            // 1. InputView로부터 계산할 문자열을 입력받음
            String input = InputView.getInputString();

            // 2. Calculator(Model)에 입력을 넘겨 계산을 실행
            int result = calculator.add(input);

            // 3. OutputView에 결과값을 넘겨 출력을 요청
            OutputView.printResult(result);

        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }
}