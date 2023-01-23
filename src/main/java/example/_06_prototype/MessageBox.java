package example._06_prototype;

class MessageBox implements Product {

    private final char c;

    MessageBox(char c) {
        this.c = c;
    }

    @Override
    public void use(String s) {
        final var line = surround(repeat(s.length()));
        final var message = surround(s);

        System.out.println(line);
        System.out.println(message);
        System.out.println(line);
    }

    private String surround(String s) {
        return c + s + c;
    }

    private String repeat(int count) {
        return Character.toString(c).repeat(count);
    }

    @Override
    public Product copy() {
        return new MessageBox(c);
    }
}
