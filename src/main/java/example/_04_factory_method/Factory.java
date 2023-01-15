package example._04_factory_method;

abstract class Factory {
    abstract Product createProduct(String name);

    abstract void registerProduct(Product product);

    final Product create(String name) {
        final Product product = createProduct(name);
        registerProduct(product);

        return product;
    }
}
