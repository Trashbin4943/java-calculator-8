package controller;

import view.InputView;

public class CalculatorController {
    public void run() {
        String inputText = InputView.getInputString();
        System.out.println("입력 확인: " + inputText);
    }
}