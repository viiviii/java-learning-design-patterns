package example._07_builder;

class Director {

    private final Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.makeTitle("Greeting")
                .makeString("일반적인 인사")
                .makeItems("How are you?", "Hello.", "Hi.")
                .makeString("시간대별 인사")
                .makeItems("Good morning.", "Good afternoon.", "Good evening.")
                .close();
    }
}
