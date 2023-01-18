package example._05_singleton;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(value = OrderAnnotation.class)
class TicketMakerTest {


    @Order(1)
    @Test
    void instanceIsSingleton() {
        //given
        var obj1 = ticketMaker();
        var obj2 = ticketMaker();

        //then
        assertThat(obj1).isSameAs(obj2);
    }

    @Order(2)
    @Test
    void instanceIsNotNull() {
        //given
        var instance = ticketMaker();

        //then
        assertThat(instance).isNotNull();
    }

    @Order(3)
    @Test
    void initialTicketNumber() {
        //given
        var ticketMaker = ticketMaker();

        //when
        var initial = ticketMaker.getNextTicketNumber();

        //then
        assertThat(initial).isEqualTo(1000);
    }

    @Order(4)
    @Test
    void nextTicketNumberIncreasesOne() {
        //given
        var ticketMaker = ticketMaker();

        //when
        var next = ticketMaker.getNextTicketNumber();

        //then
        assertThat(next).isEqualTo(1001);
    }

    private TicketMaker ticketMaker() {
        return TicketMaker.getInstance();
    }
}