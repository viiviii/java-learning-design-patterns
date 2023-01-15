package example._03_template_method;

class CharDisplay extends AbstractDisplay {
    private final char c;

    CharDisplay(char c) {
        super();
        this.c = c;
    }

    @Override
    void open() {
        System.out.print("<<");
    }

    @Override
    void print() {
        System.out.print(c);
    }

    @Override
    void close() {
        System.out.print(">>");
    }
}
