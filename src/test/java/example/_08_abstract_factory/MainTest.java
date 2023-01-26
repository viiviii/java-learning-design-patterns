package example._08_abstract_factory;

import example.MainMethodTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Arrays.array;

class MainTest extends MainMethodTest {

    @Test
    void outputList() {
        //when
        runMain(array("list"));

        //then
        assertThat(output()).isEqualTo("""
                <!DOCTYPE html>
                <html><head><title>Blog and News</title></head>
                <body>
                <h1>Blog and News</h1>
                <ul>
                <li>Blog Site
                <ul>
                  <li><a href="https://example.com/blog1">Blog 1</a></li>
                  <li><a href="https://example.com/blog2">Blog 2</a></li>
                  <li><a href="https://example.com/blog3">Blog 3</a></li>
                </ul>
                </li>
                <li>News Site
                <ul>
                  <li><a href="https://example.com/news1">News 1</a></li>
                  <li><a href="https://example.com/news2">News 2</a></li>
                  <li>News 3
                <ul>
                  <li><a href="https://example.com/news3us">News 3 (US)</a></li>
                  <li><a href="https://example.com/news3kr">News 3 (Korea)</a></li>
                </ul>
                </li>
                </ul>
                </li>
                </ul>
                <hr><address>Youngjin.com</address>
                </body></html>""");
    }

    @Test
    void outputDiv() {
        //when
        runMain(array("div"));

        //then
        assertThat(output()).isEqualTo("""
                <!DOCTYPE html>
                <html><head><title>Blog and News</title><style>
                div.TRAY { padding:0.5em; margin-left:5em; border:1px solid black; }
                div.LINK { padding:0.5em; background-color: lightgray; }
                </style></head><body>
                <h1>Blog and News</h1>
                <p><b>Blog Site</b></p>
                <div class="TRAY">
                  <div class="LINK"><a href="https://example.com/blog1">Blog 1</a></div>
                  <div class="LINK"><a href="https://example.com/blog2">Blog 2</a></div>
                  <div class="LINK"><a href="https://example.com/blog3">Blog 3</a></div>
                </div>
                <p><b>News Site</b></p>
                <div class="TRAY">
                  <div class="LINK"><a href="https://example.com/news1">News 1</a></div>
                  <div class="LINK"><a href="https://example.com/news2">News 2</a></div>
                  <p><b>News 3</b></p>
                <div class="TRAY">
                  <div class="LINK"><a href="https://example.com/news3us">News 3 (US)</a></div>
                  <div class="LINK"><a href="https://example.com/news3kr">News 3 (Korea)</a></div>
                </div>
                </div>
                <hr><address>Youngjin.com</address>
                </body></html>""");
    }


    @Override
    protected void runMain(String... args) {
        Main.main(args);
    }
}