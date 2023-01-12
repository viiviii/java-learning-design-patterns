package example._03_template_method;

class StringDisplay extends AbstractDisplay {
    private final String s;

    StringDisplay(String s) {
        super();
        this.s = s;
    }

    @Override
    void open() {
        printLine();
    }

    @Override
    void print() {
        System.out.println("|" + s + "|");
    }

    @Override
    void close() {
        printLine();
    }

    private void printLine() {
        final var dash = "-".repeat(s.length());
        System.out.println("+" + dash + "+");
    }
}
