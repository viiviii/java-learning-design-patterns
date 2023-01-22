package example._05_singleton;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SingletonTest {

    @Test
    void sameInstance() {
        //given
        var obj1 = Singleton.getInstance();
        var obj2 = Singleton.getInstance();

        //then
        assertThat(obj1).isSameAs(obj2);
    }

    @Test
    void instanceNotNull() {
        //given
        var obj1 = Singleton.getInstance();

        //then
        assertThat(obj1).isNotNull();
    }
}