package example._05_singleton;

import org.assertj.core.util.VisibleForTesting;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.HashSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;

class WrongSingletonTest {

    private final int NUMBER_OF_THREADS = 2;
    private final ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    @RepeatedTest(value = 1000, name = "{currentRepetition} / {totalRepetitions}")
    void testSingleInstanceCreationInConcurrency() throws InterruptedException {
        //given
        var holder = new HashSet<WrongSingleton>();
        var countDownLatch = new CountDownLatch(NUMBER_OF_THREADS);

        //when
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            executor.execute(() -> {
                holder.add(WrongSingleton.getInstance());
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();

        //then
        assertThat(holder.size()).isOne();
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

        static WrongSingleton getInstance() {
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