package calculator.model;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public int add(String text) {
        if (text == null || text.isEmpty()) {
            return 0; // 빈 문자열이나 null이 오면 0을 반환
        }
        List<Integer> numbers = extractNumbers(text);
        return sum(numbers);
    }

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
                int number = Integer.parseInt(str.trim());
                if (number<0){
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                }
                numbers.add(number);
            }
        }
        return numbers;
    }

    private int sum(List<Integer> numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }
}
