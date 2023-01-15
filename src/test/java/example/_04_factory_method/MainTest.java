package example._04_factory_method;

import example.MainMethodTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest extends MainMethodTest {

    @Test
    void outputContains() {
        //when
        runMain();

        //then
        assertThat(output()).contains(
                "tomi의 카드를 만듭니다.", "[IDCard:tomi]을 등록했습니다.",
                "messi의 카드를 만듭니다.", "[IDCard:messi]을 등록했습니다.",
                "min의 카드를 만듭니다.", "[IDCard:min]을 등록했습니다.",

                "[IDCard:tomi]을 사용합니다.",
                "[IDCard:messi]을 사용합니다.",
                "[IDCard:min]을 사용합니다."
        );
    }


    @Override
    protected void runMain(String... args) {
        Main.main(args);
    }
}