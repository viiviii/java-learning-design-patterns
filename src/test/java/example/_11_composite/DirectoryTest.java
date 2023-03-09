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

    @Test
    void addDirectory() {
        //given
        var root = new Directory("root");

        //when
        root.add(new Directory("bin"));

        //then
        assertThat(root.getSize()).isZero();
    }

    @Test
    void addFile() {
        //given
        var root = new Directory("root");

        //when
        root.add(new File("diary.html", 1_500));

        //then
        assertThat(root.getSize()).isEqualTo(1_500);
    }

    @Test
    void toStringOverride() {
        assertThat(new Directory("root")).hasToString("root (0)");
    }
}
