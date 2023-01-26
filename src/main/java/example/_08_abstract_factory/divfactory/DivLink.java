package example._08_abstract_factory.divfactory;

import example._08_abstract_factory.factory.Link;

class DivLink extends Link {

    protected DivLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return String.format("<div class=\"LINK\"><a href=\"%s\">%s</a></div>%n", url, caption);
    }
}
