package example._11_composite;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FileTest {

    @Test
    void name() {
        //given
        var file = new File("v1", 0);

        //when
        var actual = file.getName();

        //then
        assertThat(actual).isEqualTo("v1");
    }

    @Test
    void size() {
        //given
        var file = new File("v1", 0);

        //when
        var actual = file.getSize();

        //then
        assertThat(actual).isZero();
    }

    @Test
    void toStringOverride() {
        assertThat(new File("vi", 10000)).hasToString("vi (10000)");
    }
}
