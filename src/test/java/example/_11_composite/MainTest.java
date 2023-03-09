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
                /root (30000)
                /root/bin (30000)
                /root/bin/v1 (10000)
                /root/bin/latex (20000)
                /root/tmp (0)"""
        );
    }


    @Override
    protected void runMain(String... args) {
        Main.main(args);
    }
}