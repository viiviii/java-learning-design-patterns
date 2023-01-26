package example._08_abstract_factory.listfactory;

import example._08_abstract_factory.factory.Item;
import example._08_abstract_factory.factory.Tray;

class ListTray extends Tray {

    protected ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        final var INDENT = "  ";
        final var sb = new StringBuilder();
        sb.append("<li>").append(caption).append("\n");
        sb.append("<ul>\n");
        for (Item item : this) {
            sb.append(INDENT).append(item.makeHTML());
        }
        sb.append("</ul>\n");
        sb.append("</li>\n");
        return sb.toString();
    }
}
