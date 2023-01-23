package example._06_prototype;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


class MessageBoxTest {

    private final MessageBox box = new MessageBox('!');

    @Nested
    @DisplayName("Cloneable - 요구사항")
    class RequirementsForCloneable {

        @Test
        @DisplayName("Cloneable 인터페이스를 구현해야 한다")
        void supportsCloneableInterface() {
            assertThat(box).isInstanceOf(Cloneable.class);
        }

        @DisplayName("x.clone() != x 조건은 참이어야 한다")
        @Test
        void cloneObjectShouldNotSame() {
            assertThat(box.clone()).isNotSameAs(box);
        }
    }

    @Nested
    @DisplayName("Cloneable - 선택사항")
    class OptionsForCloneable {

        @DisplayName("x.clone().getClass() == x.getClass() 조건은 참이다")
        @Test
        void cloneObjectHasSameClass() {
            assertThat(box.clone()).hasSameClassAs(box);
        }

        @DisplayName("x.clone().equals(x) 조건은 참이다")
        @Test
        void cloneObjectEquals() {
            assertThat(box.clone()).isEqualTo(box);
        }

        @Test
        @DisplayName("재정의한 public clone()은 throws 절을 없애야 한다")
        void doesNotThrowException() {
            assertDoesNotThrow(box::clone);
        }
    }
}