package io.todo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderDemo {
	public static void main(String[] args) {
		try {
			File f = new File("d:" + File.separator + "test.txt");
			// 利用转换流，将字节输入流变成字符输入流，并用字符接收
			Reader ipr = new InputStreamReader(new FileInputStream(f));
			char[] ch = new char[(int) f.length()];
			ipr.read(ch);
			ipr.close();
			for (int i = 0; i < ch.length; i++) {
				System.out.print(ch[i]);
			}
		} catch (Exception e) {
		}
	}
}
