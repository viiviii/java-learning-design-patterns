package example._08_abstract_factory.factory;

import static com.jogamp.common.util.ReflectionUtil.createInstance;

public abstract class Factory {

    public static Factory getFactory(String className) {
        try {
            return (Factory) createInstance(Class.forName(className));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(className + " 클래스가 발견되지 않았습니다");
        }
    }

    public abstract Link createLink(String caption, String url);

    public abstract Tray createTray(String caption);

    public abstract Page createPage(String title, String author);

    public Page createNaverPage() {
        final var page = createPage("Naver", "Naver");
        page.add(createLink("Naver", "https://www.naver.com/"));

        return page;
    }
}
