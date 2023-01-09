package example._01_iterator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIndexOutOfBoundsException;

class BookShelfTest {

    private static final Book JAVA_BOOK = new Book("java");
    private static final Book PYTHON_BOOK = new Book("python");

    @Test
    void maxLength() {
        //given
        var bookShelf = new BookShelf(0);

        //then
        assertThatIndexOutOfBoundsException()
                .isThrownBy(() -> bookShelf.appendBook(JAVA_BOOK));
    }

    @Test
    void getLength() {
        //given
        var bookShelf = new BookShelf(10);

        //then
        assertThat(bookShelf.getLength()).isZero();
    }

    @Test
    void appendBook() {
        //given
        var bookShelf = new BookShelf(10);

        //when
        bookShelf.appendBook(JAVA_BOOK);

        //then
        assertThat(bookShelf.getLength()).isOne();
    }

    @Test
    void getBookAt() {
        //given
        var bookShelf = new BookShelf(10);

        bookShelf.appendBook(JAVA_BOOK);
        bookShelf.appendBook(PYTHON_BOOK);

        //when
        var lastBook = bookShelf.getBookAt(1);

        //then
        assertThat(lastBook).isEqualTo(PYTHON_BOOK);
    }

    @Test
    void iterator() {
        //given
        var bookShelf = new BookShelf(1);

        //when
        var iterator = bookShelf.iterator();

        //then
        assertThat(iterator).isNotNull();
    }
}