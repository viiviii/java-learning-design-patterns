package example._04_factory_method;

class IdCard extends Product {
    private final String name;

    public IdCard(String name) {
        this.name = name;
        logCreation();
    }

    private void logCreation() {
        System.out.println(name + "의 카드를 만듭니다.");
        System.out.println("[IDCard:" + name + "]을 등록했습니다.");
    }

    @Override
    void use() {
        System.out.println("[IDCard:" + name + "]을 사용합니다.");
    }
}
