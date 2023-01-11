package example._02_adapter;

import example.MainMethodTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest extends MainMethodTest {

    @Test
    void outputPrint() {
        //when
        runMain();

        //then
        assertThat(output()).contains("(Hello)", "*Hello*");
    }


    @Override
    protected void runMain(String... args) {
        Main.main(args);
    }
}