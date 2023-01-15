package example._04_factory_method;

class IDCardFactory extends Factory {
    @Override
    Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    void registerProduct(Product product) {
        System.out.println(product + "을 등록했습니다.");
    }
}
