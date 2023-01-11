package example._01_iterator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BookTest {

    @Test
    void getName() {
        //given
        var book = new Book("Test Book");

        //when
        var actual = book.getName();

        //then
        assertThat(actual).isEqualTo("Test Book");
    }
}