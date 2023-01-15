package example._04_factory_method;

class IDCardFactory extends Factory {
    @Override
    Product create(String name) {
        return new IdCard(name);
    }
}
