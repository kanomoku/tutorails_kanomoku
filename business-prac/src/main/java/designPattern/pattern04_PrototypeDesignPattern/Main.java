package designPattern.pattern04_PrototypeDesignPattern;

import java.util.List;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
		Employees emps = new Employees();
		emps.loadData();
		
		Employees empsNew = (Employees) emps.deepClone();
		List<String> list = empsNew.getEmpList();
		list.add("John");

		Employees empsNew1 = (Employees) emps.deepClone();
		List<String> list1 = empsNew1.getEmpList();
		list1.remove("Pankaj");
		
		System.out.println("emps List: "+emps.getEmpList());
		System.out.println("empsNew List: "+list);
		System.out.println("empsNew1 List: "+list1);
	}
}
