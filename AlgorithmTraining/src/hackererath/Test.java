package hackererath;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		Map m = new HashMap<Student, Integer>();
		Student s1 = new Student("Chetan", 1);
		Student s2 = new Student("CP2", 2);
		Student s3 = new Student("CP3", 3);
		Student s4 = new Student("CP23", 2);
		m.put(s1, 1);
		m.put(s2, 2);
		m.put(s3, 3);
		m.put(s4, 4);
		System.out.println(m.get(s4));
	}

}

class Student {
	String name;
	int age;
	
	Student(String name, int age){
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.name.equals(((Student)obj).name);
	}
	
	@Override
	public int hashCode() {
		return this.age;
	}
}