package example._11_composite;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

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

    @Test
    void addDirectory() {
        //given
        var root = new Directory("root");
        var bin = new Directory("bin");

        //when
        root.add(bin);

        //then
        assertAll(
                () -> assertThat(root).hasToString("root (0)"),
                () -> assertThat(bin).hasToString("bin (0)")
        );
    }

    @Test
    void addFile() {
        //given
        var root = new Directory("root");
        var v1 = new File("v1", 10000);

        //when
        root.add(v1);

        //then
        assertAll(
                () -> assertThat(root.getSize()).isEqualTo(10000),
                () -> assertThat(root).hasToString("root (10000)")
        );
    }

    @Test
    void toStringOverride() {
        assertThat(new Directory("root")).hasToString("root (0)");
    }
}
