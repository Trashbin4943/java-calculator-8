package model;

import calculator.model.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    private Calculator calculator;
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 합계를 반환한다.")
    void 기본_구분자_테스트() {
        String text = "1,2:3";
        int sum = calculator.add(text);
        assertThat(sum).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 지정할 경우, 해당 구분자로 분리한 합계를 반환한다.")
    void 커스텀_구분자_테스트() {
        String text = "//;\n1;2;3";
        int sum = calculator.add(text);
        assertThat(sum).isEqualTo(6);
    }

    @Test
    @DisplayName("입력값이 비어있거나 null일 경우, 0을 반환한다.")
    void 빈_값_테스트() {
        String emptyText = "";
        String nullText = null;

        int sumForEmpty = calculator.add(emptyText);
        int sumForNull = calculator.add(nullText);

        assertThat(sumForEmpty).isEqualTo(0);
        assertThat(sumForNull).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 이외의 값을 입력할 경우 IllegalArgumentException을 발생시킨다.")
    void 숫자_이외의_값_예외_테스트() {
        String text = "1,a,2";
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.add(text);
        });
    }

    @Test
    @DisplayName("음수를 입력할 경우 IllegalArgumentException을 발생시킨다.")
    void 음수_입력_예외_테스트() {
        String text = "1,-2,3";
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.add(text);
        });
    }
}