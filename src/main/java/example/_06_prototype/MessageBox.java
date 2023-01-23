package example._06_prototype;

import example._06_prototype.framework.Product;

import java.util.Objects;

final class MessageBox implements Product {

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
    public MessageBox clone() {
        try {
            return (MessageBox) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageBox that = (MessageBox) o;
        return c == that.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(c);
    }
}
