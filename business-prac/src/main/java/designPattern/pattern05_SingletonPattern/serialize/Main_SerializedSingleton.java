package designPattern.pattern05_SingletonPattern.serialize;

import org.junit.Test;

import java.io.*;

public class Main_SerializedSingleton {

    @Test
    public void test1() throws IOException, ClassNotFoundException {
        SerializedSingleton instanceOne = SerializedSingleton.getInstance();

        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.txt"));
        out.writeObject(instanceOne);
        out.close();

        // deserailize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream("filename.txt"));
        SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
        in.close();

        System.out.println("instanceOne hashCode=" + instanceOne.hashCode());
        System.out.println("instanceTwo hashCode=" + instanceTwo.hashCode());
    }

    @Test
    public void test2() throws FileNotFoundException, IOException, ClassNotFoundException {
        SerializedSingleton_ReadResolve instanceOne = SerializedSingleton_ReadResolve.getInstance();

        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.txt"));
        out.writeObject(instanceOne);
        out.close();

        // deserailize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream("filename.txt"));
        SerializedSingleton_ReadResolve instanceTwo = (SerializedSingleton_ReadResolve) in.readObject();
        in.close();

        System.out.println("instanceOne hashCode=" + instanceOne.hashCode());
        System.out.println("instanceTwo hashCode=" + instanceTwo.hashCode());
    }
}
