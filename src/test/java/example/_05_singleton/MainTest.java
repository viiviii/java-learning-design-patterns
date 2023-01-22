package example._05_singleton;

import example.MainMethodTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest extends MainMethodTest {

    @Test
    void outputSameInstance() {
        //when
        runMain();

        //then
        assertThat(output()).contains("obj1과 obj2는 같은 인스턴스입니다.");
    }

    @Override
    protected void runMain(String... args) {
        Main.main(args);
    }
}