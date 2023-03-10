package designPattern.designPatterns05_SingletonPattern;

import java.io.Serializable;

public class SerializedSingletonReadResolve implements Serializable {

    private static final long serialVersionUID = -7604766932017737115L;

    private SerializedSingletonReadResolve() {
    }

    private static class SingletonHelper {
        private static final SerializedSingletonReadResolve instance = new SerializedSingletonReadResolve();
    }

    public static SerializedSingletonReadResolve getInstance() {
        return SingletonHelper.instance;
    }

    protected Object readResolve() {
        return getInstance();
    }
}
