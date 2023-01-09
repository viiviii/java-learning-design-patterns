package example._01_iterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookShelfIteratorTest {

    private static final Book BOOK = new Book("test book");

    @Test
    void next() {
        //given
        var iterator = new BookShelfIterator(bookShelfWith(BOOK));

        //when
        var actual = iterator.next();

        //then
        assertThat(actual).isEqualTo(BOOK);
    }

    @Test
    void nextThrownExceptionWhenHasNextIsFalse() {
        //given
        var iterator = new BookShelfIterator(emptyBookShelf());

        //then
        Assertions.assertAll(
                () -> assertFalse(iterator.hasNext()),
                () -> assertThatThrownBy(iterator::next)
        );
    }

    @Test
    void hasNextReturnsTrue() {
        //given
        var iterator = new BookShelfIterator(bookShelfWith(BOOK));

        //when
        var hasNext = iterator.hasNext();

        //then
        assertTrue(hasNext);
    }

    @Test
    void hasNextReturnsFalseWhenHasNoMoreElements() {
        //given
        var iterator = new BookShelfIterator(bookShelfWith(BOOK));

        //when
        iterator.next();
        var hasNext = iterator.hasNext();

        //then
        assertFalse(hasNext);
    }

    private BookShelf bookShelfWith(Book book) {
        var bookshelf = emptyBookShelf();
        bookshelf.appendBook(book);
        return bookshelf;
    }

    private BookShelf emptyBookShelf() {
        return new BookShelf(10);
    }
}