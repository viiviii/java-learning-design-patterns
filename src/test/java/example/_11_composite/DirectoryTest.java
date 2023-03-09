package example._11_composite;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectoryTest {

    @Test
    void name() {
        //given
        var directory = new Directory("root");

        //when
        var actual = directory.getName();

        //then
        assertThat(actual).isEqualTo("root");
    }

    @Test
    void size() {
        //given
        var directory = new Directory("root");

        //when
        var actual = directory.getSize();

        //then
        assertThat(actual).isZero();
    }
}
