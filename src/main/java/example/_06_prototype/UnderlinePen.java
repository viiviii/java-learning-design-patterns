package example._06_prototype;

import example._06_prototype.framework.Product;

class UnderlinePen implements Product {

    private final char c;

    UnderlinePen(char c) {
        this.c = c;
    }

    @Override
    public void use(String s) {
        final var underline = repeat(s.length());

        System.out.println(s);
        System.out.println(underline);
    }

    private String repeat(int count) {
        return Character.toString(c).repeat(count);
    }

    @Override
    public Product copy() {
        return new UnderlinePen(c);
    }
}
