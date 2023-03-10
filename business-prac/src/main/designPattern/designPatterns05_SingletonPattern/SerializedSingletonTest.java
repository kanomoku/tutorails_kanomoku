package designPattern.designPatterns05_SingletonPattern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class SerializedSingletonTest {

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
        SerializedSingletonReadResolve instanceOne = SerializedSingletonReadResolve.getInstance();

        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.txt"));
        out.writeObject(instanceOne);
        out.close();

        // deserailize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream("filename.txt"));
        SerializedSingletonReadResolve instanceTwo = (SerializedSingletonReadResolve) in.readObject();
        in.close();

        System.out.println("instanceOne hashCode=" + instanceOne.hashCode());
        System.out.println("instanceTwo hashCode=" + instanceTwo.hashCode());
    }
}
