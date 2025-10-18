package calculator.model;

import calculator.model.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 숫자 리스트를 반환한다.")
    void 기본_구분자_테스트() {
        // 준비 (Arrange)
        Calculator calculator = new Calculator();
        String text = "1,2:3";

        // 실행 (Act)
        List<Integer> numbers = calculator.extractNumbers(text);

        // 검증 (Assert)
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("커스텀 구분자를 지정할 경우, 해당 구분자로 분리한 숫자 리스트를 반환한다.")
    void 커스텀_구분자_테스트() {
        // 준비 (Arrange)
        Calculator calculator = new Calculator();
        String text = "//;\n1;2;3";

        // 실행 (Act)
        List<Integer> numbers = calculator.extractNumbers(text);

        // 검증 (Assert)
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("입력값이 비어있거나 null일 경우, 빈 리스트를 반환한다.")
    void 빈_값_테스트() {
        // 준비 (Arrange)
        Calculator calculator = new Calculator();
        String text = "";

        // 실행 (Act)
        List<Integer> numbers = calculator.extractNumbers(text);

        // 검증 (Assert)
        assertThat(numbers).isEmpty();
    }
}