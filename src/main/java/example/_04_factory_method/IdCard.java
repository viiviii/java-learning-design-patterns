package example._04_factory_method;

class IdCard extends Product {
    private final String name;

    public IdCard(String name) {
        this.name = name;
    }

    @Override
    void use() {
        System.out.println(this + "을 사용합니다.");
    }

    @Override
    public String toString() {
        return "[IDCard:" + name + "]";
    }
}
