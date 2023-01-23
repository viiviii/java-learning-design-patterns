package example._06_prototype;

import example._06_prototype.framework.Product;

import java.util.Objects;

final class UnderlinePen implements Product {

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
    public UnderlinePen clone() {
        try {
            return (UnderlinePen) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnderlinePen that = (UnderlinePen) o;
        return c == that.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(c);
    }
}
