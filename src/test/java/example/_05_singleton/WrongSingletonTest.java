package example._05_singleton;

import org.assertj.core.util.VisibleForTesting;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.assertj.core.api.Assertions.assertThat;

class WrongSingletonTest {

    private final int NUMBER_OF_THREADS = 2;
    private final ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    @RepeatedTest(value = 1000, name = "{currentRepetition} / {totalRepetitions}")
    void testSingleInstanceCreationInConcurrency() throws ExecutionException, InterruptedException {
        //when
        Future<WrongSingleton> obj1 = executor.submit(WrongSingleton::getInstance);
        Future<WrongSingleton> obj2 = executor.submit(WrongSingleton::getInstance);

        //then
        assertThat(obj1.get()).isSameAs(obj2.get());
    }

    @AfterEach
    void tearDown() {
        executor.shutdownNow();
        WrongSingleton.clearInstance();
    }

    private static final class WrongSingleton {

        private static WrongSingleton instance = null;

        private WrongSingleton() {
            System.out.println("인스턴스를 생성했습니다.");
        }

        static synchronized WrongSingleton getInstance() {
            if (instance == null) {
                instance = new WrongSingleton();
            }

            return instance;
        }

        @VisibleForTesting
        static void clearInstance() {
            instance = null;
        }
    }
}