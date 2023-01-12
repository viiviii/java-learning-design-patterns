package example._03_template_method;

import example.MainMethodTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest extends MainMethodTest {

    @Test
    void outputDisplays() {
        //given
        var expectedCharDisplay = "<<HHHHH>>";
        var expectedStringDisplay = """
                +-------------+
                |Hello, world.|
                |Hello, world.|
                |Hello, world.|
                |Hello, world.|
                |Hello, world.|
                +-------------+""";

        //when
        runMain();
        System.out.println(expectedStringDisplay);

        //then
        assertThat(output()).contains(expectedCharDisplay, expectedStringDisplay);
    }

    @Override
    protected void runMain(String... args) {
        Main.main(args);
    }
}