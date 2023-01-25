package example._07_builder;

class HTMLBuilder extends Builder {

    private final StringBuilder sb = new StringBuilder();

    public HTMLBuilder() {
        sb.append("<!DOCTYPE html>\n");
        sb.append("<html>\n");
    }

    @Override
    public Builder makeTitle(String title) {
        sb.append("<head><title>").append(title).append("</title></head>\n");
        sb.append("<body>\n");
        sb.append("<h1>").append(title).append("</h1>\n\n");
        return this;
    }

    @Override
    public Builder makeString(String str) {
        sb.append("<p>").append(str).append("</p>\n\n");
        return this;
    }

    @Override
    public Builder makeItems(String... items) {
        sb.append("<ul>\n");
        for (String item : items) {
            sb.append("<li>").append(item).append("</li>\n");
        }
        sb.append("</ul>\n\n");
        return this;
    }

    @Override
    public void close() {
        sb.append("</body></html>\n");
    }

    public String getHTMLResult() {
        return sb.toString();
    }
}
