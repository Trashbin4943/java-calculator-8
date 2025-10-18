package main.java.calculator.model;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public void processInput(String text) {
        String delimiter = "[,:]";
        String numbersText = text;

        if (text != null && text.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
            if (matcher.find()) {
                delimiter = matcher.group(1);
                numbersText = matcher.group(2);
            }
        }

        System.out.println("선택된 구분자: " + delimiter);
        System.out.println("분리할 숫자 문자열: " + numbersText);
    }
}
