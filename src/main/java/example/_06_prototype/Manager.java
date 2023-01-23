package example._06_prototype;

import java.util.HashMap;
import java.util.Map;

class Manager {
    private Map<String, Product> products = new HashMap<>();

    public void register(String name, Product product) {
        products.put(name, product);
    }

    public Product create(String name) {
        final var product = products.get(name);
        return product.copy(); // todo: ??? 왜 복사할까
    }
}
