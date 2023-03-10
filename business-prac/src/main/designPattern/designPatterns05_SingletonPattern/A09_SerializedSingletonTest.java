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

public class A09_SerializedSingletonTest {

	@Test
	public void test1() throws FileNotFoundException, IOException, ClassNotFoundException {
		A07_SerializedSingleton instanceOne = A07_SerializedSingleton.getInstance();
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
		out.writeObject(instanceOne);
		out.close();

		// deserailize from file to object
		ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
		A07_SerializedSingleton instanceTwo = (A07_SerializedSingleton) in.readObject();
		in.close();

		System.out.println("instanceOne hashCode=" + instanceOne.hashCode());
		System.out.println("instanceTwo hashCode=" + instanceTwo.hashCode());
		System.out.println("---------------------------------------");
	}
	@Test
	public void test2() throws FileNotFoundException, IOException, ClassNotFoundException {
		A08_SerializedSingletonReadResolve instanceOne = A08_SerializedSingletonReadResolve.getInstance();
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
		out.writeObject(instanceOne);
		out.close();

		// deserailize from file to object
		ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
		A08_SerializedSingletonReadResolve instanceTwo = (A08_SerializedSingletonReadResolve) in.readObject();
		in.close();

		System.out.println("instanceOne hashCode=" + instanceOne.hashCode());
		System.out.println("instanceTwo hashCode=" + instanceTwo.hashCode());
		System.out.println("---------------------------------------");
	}
}
