package example._06_prototype;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


class MessageBoxTest {

    @Test
    void copy() {
        assertDoesNotThrow(() -> new MessageBox('!').copy());
    }
}