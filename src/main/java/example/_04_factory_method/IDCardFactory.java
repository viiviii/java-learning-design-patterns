package example._04_factory_method;

class IDCardFactory extends Factory {
    @Override
    Product createProduct(String name) {
        System.out.println(name + "의 카드를 만듭니다.");
        return new IdCard(name);
    }

    @Override
    void registerProduct(Product product) {
        System.out.println(product + "을 등록했습니다.");
    }
}
