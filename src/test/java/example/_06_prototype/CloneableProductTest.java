package example._06_prototype;

import example._06_prototype.framework.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


class CloneableProductTest {

    private final Product product = new MessageBox('!');

    @Nested
    @DisplayName("요구사항")
    class RequirementsForCloneable {

        @Test
        @DisplayName("Cloneable 인터페이스를 구현해야 한다")
        void supportsCloneableInterface() {
            assertThat(product).isInstanceOf(Cloneable.class);
        }

        @DisplayName("x.clone() != x 조건은 참이어야 한다")
        @Test
        void cloneObjectShouldNotSame() {
            assertThat(product.clone()).isNotSameAs(product);
        }
    }

    @Nested
    @DisplayName("선택사항")
    class OptionsForCloneable {

        @DisplayName("x.clone().getClass() == x.getClass() 조건은 참이다")
        @Test
        void cloneObjectHasSameClass() {
            assertThat(product.clone()).hasSameClassAs(product);
        }

        @DisplayName("x.clone().equals(x) 조건은 참이다")
        @Test
        void cloneObjectEquals() {
            assertThat(product.clone()).isEqualTo(product);
        }

        @Test
        @DisplayName("재정의한 public clone()은 throws 절을 없애야 한다")
        void doesNotThrowException() {
            assertDoesNotThrow(product::clone);
        }
    }

    @Nested
    @DisplayName("반환된 객체는 super.clone 호출로 얻어야 함")
    class ShouldObtainBySuperClone {

        @Test
        @DisplayName("올바름: super.clone()을 사용해서 얻음")
        void correct() {
            assertDoesNotThrow(() -> new CollectChild().clone());
        }

        class CorrectParent implements Cloneable {
            @Override
            public CorrectParent clone() {
                try {
                    return (CorrectParent) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError();
                }
            }
        }

        class CollectChild extends CorrectParent {
            @Override
            public CollectChild clone() {
                return (CollectChild) super.clone();
            }
        }

        @Test
        @DisplayName("잘못됨: 부모가 자신의 생성자를 사용해서 얻음")
        void wrong() {
            assertThatThrownBy(() -> new WrongChild().clone())
                    .isInstanceOf(ClassCastException.class);
        }

        class WrongParent implements Cloneable {
            @Override
            public WrongParent clone() {
                return new WrongParent(); // 생성자로 호출
            }
        }

        class WrongChild extends WrongParent {
            @Override
            public WrongChild clone() {
                return (WrongChild) super.clone();
            }
        }
    }
}