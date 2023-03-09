package example._12_decorator;

import example.MainMethodTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest extends MainMethodTest {

    @Test
    void decorator() {
        //given

        //when
        runMain();

        //then
        assertThat(output()).isEqualTo("""
                Hello, world.
                #Hello, world.#""");
    }


    @Override
    protected void runMain(String... args) {
        Main.main(args);
    }
}