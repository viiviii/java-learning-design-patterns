package example._04_factory_method;

abstract class Factory {
    abstract Product createProduct(String owner);

    abstract void registerProduct(Product product);

    final Product create(String owner) {
        final Product product = createProduct(owner);
        registerProduct(product);

        return product;
    }
}
