package example._07_builder;

import example.MainMethodTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Arrays.array;

class MainTest extends MainMethodTest {

    @Test
    void outputText() {
        //when
        Main.main(array("text"));

        //then
        assertThat(output()).isEqualTo("""
                ==============================
                [Greeting]
                                
                ■일반적인 인사
                                
                - How are you?
                - Hello.
                - Hi.
                                
                ■시간대별 인사
                                
                - Good morning.
                - Good afternoon.
                - Good evening.
                                
                ==============================""");
    }

    @Test
    void outputHTML() {
        //when
        Main.main(array("html"));

        //then
        assertThat(output()).isEqualTo("""
                <!DOCTYPE html>
                <html>
                <head><title>Greeting</title></head>
                <body>
                <h1>Greeting</h1>
                                
                <p>일반적인 인사</p>
                                
                <ul>
                <li>How are you?</li>
                <li>Hello.</li>
                <li>Hi.</li>
                </ul>
                                
                <p>시간대별 인사</p>
                                
                <ul>
                <li>Good morning.</li>
                <li>Good afternoon.</li>
                <li>Good evening.</li>
                </ul>
                                
                </body></html>""");
    }

    @Override
    protected void runMain(String... args) {
        Main.main(args);
    }
}