package example._07_builder;

abstract class Builder {

    // 책 예제와 같음
    public abstract Builder makeTitle(String title);

    public abstract Builder makeString(String str);

    public abstract Builder makeItems(String... items);

    public abstract void close();

    // 여기서부턴 내가 하다보니 추가한 것들
    private final StringBuilder sb = new StringBuilder();

    protected final Builder appendWithNewLine(String str) {
        append(str).appendNewLine();
        return this;
    }

    protected final Builder appendNewLine() {
        append(System.lineSeparator());
        return this;
    }

    protected final Builder append(String str) {
        sb.append(str);
        return this;
    }

    protected final String getResult() {
        return sb.toString();
    }
}
