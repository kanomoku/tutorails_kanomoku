package designPattern.designPatterns05_SingletonPattern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import org.junit.jupiter.api.Test;

public class A12_CloneTest {

	@Test
	public void test1() throws FileNotFoundException, IOException, ClassNotFoundException {
		try {
		A11_EagerInitializedSingletonClone instanceOne = A11_EagerInitializedSingletonClone.getInstance();
			A11_EagerInitializedSingletonClone instanceOne2  = instanceOne.clone();
			System.out.println(instanceOne==instanceOne2);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
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
