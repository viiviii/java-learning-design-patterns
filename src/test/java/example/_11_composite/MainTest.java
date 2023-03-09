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
                /root/tmp (0)
                /root/usr (0)
                                
                Making user entries...
                /root (31500)
                /root/bin (30000)
                /root/bin/v1 (10000)
                /root/bin/latex (20000)
                /root/tmp (0)
                /root/usr (1500)
                /root/usr/youngjin (300)
                /root/usr/youngjin/diary.html (100)
                /root/usr/youngjin/Composite.java (200)
                /root/usr/gildong (300)
                /root/usr/gildong/memo.tex (300)
                /root/usr/dojun (900)
                /root/usr/dojun/game.doc (400)
                /root/usr/dojun/junk.mail (500)"""
        );
    }


    @Override
    protected void runMain(String... args) {
        Main.main(args);
    }
}