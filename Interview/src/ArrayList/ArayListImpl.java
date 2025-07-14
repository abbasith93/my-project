package ArrayList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ArayListImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list=new ArrayList<Integer>();

		
		for(int i=1;i<=10;i++)
			list.add(i);
		
		/*
		 * list.add(null); list.add(null);
		 */
		
		for(int x:list)
			System.out.println(x);
		
		
		HashMap<Integer, String> hm=new HashMap<>();
		hm.put(1, "xyz");
		hm.put(2, "abc");
		hm.put(3,"interview");
		hm.put(1, "efg");
		
		for(int i:hm.keySet()) {
			System.out.println(hm.get(i));
		}
		
		hm.forEach((x,y)->
		{
			System.out.println(x + " " +y);
		});
		
		HashSet<String> hs=new HashSet<>();
		hs.add("1");
		hs.add("2");
		hs.add("3");
		hs.add("1");
		
		for(String x:hs) {
			System.out.println(x);
		}
	}

}
