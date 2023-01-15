package example._04_factory_method;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IDCardTest {

    @Test
    void testToString() {
        //given
        var tomiCard = new IDCard("tomi");

        //when
        String actual = tomiCard.toString();

        //then
        assertThat(actual).isEqualTo("[IDCard:tomi]");
    }
}