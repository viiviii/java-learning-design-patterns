package example._06_prototype;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


class CloneableConventionsTest {

    private final Correct correct = new Correct();

    @Nested
    @DisplayName("clone()을 override 할 때")
    class WhenOverrideTheCloneMethod {

        @Test
        @DisplayName("Cloneable 인터페이스를 구현해야 한다")
        void implementsCloneableInterface() {
            assertThat(correct).isInstanceOf(Cloneable.class);
        }

        @Test
        @DisplayName("반환 타입은 클래스 자신으로 해라")
        void returnsTypeShouldBeItself() {
            assertThat(correct).isInstanceOf(Correct.class);
        }

        @Test
        @DisplayName("throws 절은 없애라")
        void doesNotThrowException() {
            assertDoesNotThrow(correct::clone);
        }
    }

    @Nested
    @DisplayName("일반적으로 만족하는 표현식")
    class GenerallyTrueExpressions {

        @DisplayName("x.clone() != x 조건은 참이다")
        @Test
        void isNotSame() {
            assertThat(correct.clone()).isNotSameAs(correct);
        }

        @DisplayName("x.clone().getClass() == x.getClass() 조건은 참이다")
        @Test
        void hasSameClass() {
            assertThat(correct.clone()).hasSameClassAs(correct);
        }

        @DisplayName("x.clone().equals(x) 조건은 참이다")
        @Test
        void equals() {
            assertThat(correct.clone()).isEqualTo(correct);
        }
    }

    @Nested
    @DisplayName("super.clone()로 얻은 객체를 리턴하자")
    class ShouldObtainBySuperClone {

        @Test
        @DisplayName("올바름: 모두 super.clone()을 사용해서 얻음")
        void correct() {
            assertDoesNotThrow(() -> new CorrectChild().clone());
        }

        @Test
        @DisplayName("잘못됨: 부모가 자신의 생성자를 사용해서 얻음")
        void wrong() {
            assertThatThrownBy(() -> new WrongChild().clone())
                    .isInstanceOf(ClassCastException.class);
        }
    }

    class Correct implements Cloneable {
        private final String value = "for equals() testing";

        @Override
        public Correct clone() {
            try {
                return (Correct) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Correct correct = (Correct) o;
            return Objects.equals(value, correct.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

    class CorrectChild extends Correct {
        @Override
        public CorrectChild clone() {
            return (CorrectChild) super.clone();
        }
    }

    class Wrong implements Cloneable {
        @Override
        public Wrong clone() {
            // 잘못됨: 생성자로 호출
            return new Wrong();
        }
    }

    class WrongChild extends Wrong {
        @Override
        public WrongChild clone() {
            // 부모에서 생성자로 생성한 객체를 반환해서, 자식의 반환 타입도 부모 타입으로 강제됨
            // - 그래서 아래와 같이 형변환 시 예외가 발생함
            //
            // clone()을 연쇄적으로 호출하면 clone()이 처음 호출된 하위 클래스의 객체가 만들어짐
            // - 공변 반환 타입(covariant return type)이라고 함
            return (WrongChild) super.clone();
        }
    }
}