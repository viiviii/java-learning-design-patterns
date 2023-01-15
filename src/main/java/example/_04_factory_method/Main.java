package example._04_factory_method;

import example._04_factory_method.framework.Factory;
import example._04_factory_method.framework.Product;
import example._04_factory_method.idcard.IDCardFactory;

class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("tomi");
        Product card2 = factory.create("messi");
        Product card3 = factory.create("min");
        card1.use();
        card2.use();
        card3.use();
    }
}
