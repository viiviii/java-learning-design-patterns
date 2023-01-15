package example._04_factory_method.framework;

public abstract class Factory {
    public final Product create(String owner) {
        final Product product = createProduct(owner);
        registerProduct(product);

        return product;
    }

    protected abstract Product createProduct(String owner);

    protected abstract void registerProduct(Product product);
}
