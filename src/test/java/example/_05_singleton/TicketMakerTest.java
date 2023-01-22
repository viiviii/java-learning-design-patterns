package example._05_singleton;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(value = OrderAnnotation.class)
class TicketMakerTest {

    private final TicketMaker ticketMaker = ticketMaker();

    @Order(1)
    @Test
    void initialTicketNumber() {
        //when
        var initial = ticketMaker.getNextTicketNumber();

        //then
        assertThat(initial).isEqualTo(1000);
    }

    @Test
    void instanceIsSingleton() {
        //given
        var other = ticketMaker();

        //then
        assertThat(ticketMaker).isSameAs(other);
    }

    @Test
    void nextTicketNumberIncreasesOne() {
        //given
        var previous = ticketMaker.getNextTicketNumber();

        //when
        var ticketNumber = ticketMaker.getNextTicketNumber();

        //then
        assertThat(ticketNumber).isEqualTo(previous + 1);
    }

    @Nested
    class WhenConcurrency {
        private final ExecutorService executor = Executors.newFixedThreadPool(2);

        @RepeatedTest(value = 10_000, name = "{currentRepetition} / {totalRepetitions}")
        void multiThreads() throws ExecutionException, InterruptedException {
            //when
            Future<Integer> ticketNumber = executor.submit(ticketMaker::getNextTicketNumber);
            Future<Integer> other = executor.submit(ticketMaker::getNextTicketNumber);

            //then
            assertThat(ticketNumber.get()).isNotEqualTo(other.get());
        }

        @AfterEach
        void tearDown() {
            executor.shutdownNow();
        }
    }

    private TicketMaker ticketMaker() {
        return TicketMaker.getInstance();
    }
}