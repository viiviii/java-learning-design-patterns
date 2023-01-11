package example._01_iterator;

import example.MainMethodTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest extends MainMethodTest {

    @Test
    void outputBookNames() {
        //given
        var expectedBookNames = List.of(
                "Around the World in 80 Days",
                "Bible",
                "Cinderella",
                "Daddy-Long-Legs"
        );

        //when
        runMain();

        //then
        assertThat(output()).contains(expectedBookNames);
    }

    @Override
    protected void runMain(String... args) {
        Main.main(args);
    }
}