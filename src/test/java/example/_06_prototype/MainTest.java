package example._06_prototype;

import example.MainMethodTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest extends MainMethodTest {

    @Test
    void outputUsedProduct() {
        //given
        var strongMessage = """
                Hello, world.
                -------------""";
        var warningBox = """
                ***************
                *Hello, world.*
                ***************""";
        var slashBox = """
                ///////////////
                /Hello, world./
                ///////////////
                """;

        //when
        runMain();

        //then
        assertThat(output()).contains(strongMessage, warningBox, slashBox);
    }

    @Override
    protected void runMain(String... args) {
        Main.main(args);
    }
}