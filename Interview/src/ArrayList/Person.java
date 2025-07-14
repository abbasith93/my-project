package ArrayList;

public class Person {
	private int age;
	private String name;
	
	public Person(int age,String name) {
		// TODO Auto-generated constructor stub
		this.age=age;
		this.name=name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	
	
	
	
	
}
