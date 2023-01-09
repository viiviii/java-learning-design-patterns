package example._01_iterator;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIndexOutOfBoundsException;

class BookShelfTest {

    @Test
    void maxLength() {
        //given
        var bookShelf = new BookShelf(0);

        //when
        ThrowingCallable appendOverMaxLength = () -> {
            bookShelf.appendBook(book());
        };

        //then
        assertThatIndexOutOfBoundsException().isThrownBy(appendOverMaxLength);
    }

    @Test
    void appendBook() {
        //given
        var lengthOfBooks = 3;
        var bookShelf = new BookShelf(lengthOfBooks);

        //when
        bookShelf.appendBook(book());
        bookShelf.appendBook(book());
        bookShelf.appendBook(book());

        //then
        assertThat(bookShelf.getLength()).isEqualTo(lengthOfBooks);
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

    private Book book() {
        return new Book("test book");
    }
}