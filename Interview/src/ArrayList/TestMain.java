package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person p1=new Person(20, "Abdul");
		Person p2=new Person(22, "Sufiyan");
		Person p3=new Person(25, "taj");
		Person p4=new Person(30, "Safvan");
		Person p5=new Person(30, "Amit");
		
		List<Person> list=new ArrayList<>();
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		
		//System.out.println(list);
		
		List<Person> p=list.stream().filter(x->x.getAge()>25).toList();
		System.out.println(p);
		
		List<Integer> numbers = Arrays.asList(5, 3, 9, 12, 4, 12, 8, 3, 9, 5);
		
		List<Integer> num=numbers.stream().collect(Collectors.groupingBy(e->e,Collectors.counting()))
				.entrySet().stream().filter(x->x.getValue()>1)
				.map(Map.Entry::getKey).collect(Collectors.toList());
		
		System.out.println(num);
	}

}
