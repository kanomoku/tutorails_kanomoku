package designPattern.pattern05_SingletonPattern.serialize;

import java.io.Serializable;

public class SerializedSingleton_ReadResolve implements Serializable {

    private static final long serialVersionUID = -7604766932017737115L;

    private SerializedSingleton_ReadResolve() {
    }

    private static class SingletonHelper {
        private static final SerializedSingleton_ReadResolve instance = new SerializedSingleton_ReadResolve();
    }

    public static SerializedSingleton_ReadResolve getInstance() {
        return SingletonHelper.instance;
    }

    protected Object readResolve() {
        return getInstance();
    }
}
