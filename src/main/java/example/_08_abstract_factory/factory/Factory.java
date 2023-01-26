package example._08_abstract_factory.factory;

import com.jogamp.common.util.ReflectionUtil;

public abstract class Factory {

    public static Factory getFactory(String className) {
        try {
            final var instance = ReflectionUtil.createInstance(Class.forName(className));
            return (Factory) instance;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(className + " 클래스가 발견되지 않았습니다");
        }
    }

    public abstract Link createLink(String caption, String url);

    public abstract Tray createTray(String caption);

    public abstract Page createPage(String title, String author);
}
