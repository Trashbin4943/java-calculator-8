package calculator.view;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getInputString() {
        System.out.println("덧셈할 문자열을 입력하세요.");
        return Console.readLine();
    }
}