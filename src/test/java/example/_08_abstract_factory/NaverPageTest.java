package example._08_abstract_factory;

import example._08_abstract_factory.factory.Factory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NaverPageTest {

    private final String PACKAGE_ROOT = this.getClass().getPackage().getName();

    @Test
    void divPage() {
        //given
        var factory = Factory.getFactory(PACKAGE_ROOT + ".divfactory.DivFactory");

        //when
        var page = factory.createNaverPage();

        //then
        assertThat(page.makeHTML()).isEqualTo("""
                <!DOCTYPE html>
                <html><head><title>Naver</title><style>
                div.TRAY { padding:0.5em; margin-left:5em; border:1px solid black; }
                div.LINK { padding:0.5em; background-color: lightgray; }
                </style></head><body>
                <h1>Naver</h1>
                <div class="LINK"><a href="https://www.naver.com/">Naver</a></div>
                <hr><address>Naver</address>
                </body></html>""");
    }

    @Test
    void listPage() {
        //given
        var factory = Factory.getFactory(PACKAGE_ROOT + ".listfactory.ListFactory");

        //when
        var page = factory.createNaverPage();

        //then
        assertThat(page.makeHTML()).isEqualTo("""
                <!DOCTYPE html>
                <html><head><title>Naver</title></head>
                <body>
                <h1>Naver</h1>
                <ul>
                <li><a href="https://www.naver.com/">Naver</a></li>
                </ul>
                <hr><address>Naver</address>
                </body></html>""");
    }

}
