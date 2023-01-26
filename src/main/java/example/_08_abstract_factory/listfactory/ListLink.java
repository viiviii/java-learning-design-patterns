package example._08_abstract_factory.listfactory;

import example._08_abstract_factory.factory.Link;

class ListLink extends Link {

    protected ListLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return String.format("<li><a href=\"%s\">%s</a></li>%n", url, caption);
    }
}
