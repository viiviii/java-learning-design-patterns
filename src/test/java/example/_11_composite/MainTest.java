package example._11_composite;

import example.MainMethodTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest extends MainMethodTest {

    @Test
    void outputRootEntries() {
        //when
        runMain();

        //then
        assertThat(output()).isEqualTo("""
                Making root entries...
                /root (0)"""
        );
    }


    @Override
    protected void runMain(String... args) {
        Main.main(args);
    }
}