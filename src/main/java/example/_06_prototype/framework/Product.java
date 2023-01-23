package example._06_prototype.framework;

public interface Product extends Cloneable {
    void use(String s);

    Product clone();
}
