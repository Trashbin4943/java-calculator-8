package calculator;
import controller.CalculatorController;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("계산할 문자열을 입력하세요:");
        String inputText = scanner.nextLine();

        scanner.close();
    }
}
