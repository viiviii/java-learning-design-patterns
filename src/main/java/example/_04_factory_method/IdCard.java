package example._04_factory_method;

class IdCard extends Product {
    private final String name;

    public IdCard(String name) {
        this.name = name;
    }

    @Override
    void use() {
        System.out.println("[IDCard:" + name + "]을 사용합니다.");
    }
}
