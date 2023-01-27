package example._09_bridge;

import example.MainMethodTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest extends MainMethodTest {

    @Test
    void outputDisplays() {
        //when
        runMain();

        //then
        assertThat(output()).isEqualTo("""
                +-------------+
                |Hello, Korea.|
                +-------------+
                +-------------+
                |Hello, World.|
                +-------------+
                +----------------+
                |Hello, Universe.|
                +----------------+
                +----------------+
                |Hello, Universe.|
                |Hello, Universe.|
                |Hello, Universe.|
                |Hello, Universe.|
                |Hello, Universe.|
                +----------------+""");
    }

    //todo
    @Override
    protected void runMain(String... args) {
        Main.main(args);
    }
}