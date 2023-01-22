package example._05_singleton;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class TripleTest {

    @Test
    void singleton() {
        assertAll(
                () -> assertThat(Triple.ALPHA).isSameAs(Triple.ALPHA),
                () -> assertThat(Triple.BETA).isSameAs(Triple.BETA),
                () -> assertThat(Triple.GAMMA).isSameAs(Triple.GAMMA)
        );
    }

    @Test
    void getInstance() {
        assertAll(
                () -> assertThat(Triple.getInstance("ALPHA")).isSameAs(Triple.ALPHA),
                () -> assertThat(Triple.getInstance("BETA")).isSameAs(Triple.BETA),
                () -> assertThat(Triple.getInstance("GAMMA")).isSameAs(Triple.GAMMA)
        );
    }
}