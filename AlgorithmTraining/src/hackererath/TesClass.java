package hackererath;
import java.util.Iterator;
import java.util.TreeSet;

import graph.Test;

/*class A{}

class B extends A{}

class C extends B{}

class D extends C{}
*/
public class TesClass {
	
	static int count = 100;
	public void ince() {
		count++;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	String userName = "hello";
		Object o = userName;
		if(o.equals(userName)){
			System.out.print("A");
		}
		else {
			System.out.print("B");
		}
		if(userName.equals(o)){
			System.out.print("C");
		}
		else {
			System.out.print("D");
		}*/
		
/*		B b = new C();
		A a = b;
		if(a instanceof A){
			System.out.print("A");
		}
		if(a instanceof B){
			System.out.print("B");
		}
		if(a instanceof C){
			System.out.print("C");
		}
		if(a instanceof D){
			System.out.print("D");
		}
*/		
		/*Test t = new Test();
		System.out.print(t.y);
		System.out.print("D");
		*/
		/*
		TesClass tesClass = new TesClass();
		tesClass.ince();
		TesClass te = new TesClass();
		System.out.print(te.count);*/
		TreeSet<String> map = new TreeSet<>();
		map.add("one");
		map.add("two");
		map.add("three");
		map.add("four");
		map.add("one");
		
		Iterator<String> it = map.iterator();
		while (it.hasNext()) {
			System.out.print(it.next());
		}
		
		
	}
		

}
