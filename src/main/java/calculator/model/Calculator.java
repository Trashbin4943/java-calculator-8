package calculator.model;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public List<Integer> extractNumbers(String text) {
        if (text == null || text.isEmpty()) {
            return new ArrayList<>();
        }

        String delimiter = "[,:]";
        String numbersText = text;

        if (text.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
            if (matcher.find()) {
                delimiter = matcher.group(1);
                numbersText = matcher.group(2);
            }
        }

        return convertToNumbers(numbersText.split(delimiter));
    }

    private List<Integer> convertToNumbers(String[] numberStrings) {
        List<Integer> numbers = new ArrayList<>();
        for (String str : numberStrings) {
            if (!str.trim().isEmpty()) {
                numbers.add(Integer.parseInt(str.trim()));
            }
        }
        return numbers;
    }
}
