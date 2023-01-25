package example._07_builder;

class TextBuilder extends Builder {

    private static final String OPENING_CLOSING_LINE = "==============================\n";

    private final StringBuilder sb = new StringBuilder();


    public TextBuilder() {
        sb.append(OPENING_CLOSING_LINE);
    }

    @Override
    public Builder makeTitle(String title) {
        sb.append("[").append(title).append("]\n\n");
        return this;

    }

    @Override
    public Builder makeString(String str) {
        sb.append("■").append(str).append("\n\n");
        return this;
    }

    @Override
    public Builder makeItems(String... items) {
        for (String item : items) {
            sb.append("- ").append(item).append("\n");
        }
        sb.append("\n");
        return this;
    }

    @Override
    public void close() {
        sb.append(OPENING_CLOSING_LINE);
    }

    public String getTextResult() {
        return sb.toString();
    }
}
