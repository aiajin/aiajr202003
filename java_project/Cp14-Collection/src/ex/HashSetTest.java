package ex;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		
		HashSet<String> set = new HashSet<String>();
		//HashSet<String> set = new HashSet<>();
		//Set<String> set = new HashSet<>();
		
		set.add("First");
		set.add("Second");
		set.add("Third");
		set.add("First");
		
		System.out.println("저장된 데이터의 개수 : " + set.size());
		
		Iterator<String> itr = set.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
		
		
		
		
		
		
		
		
		
		

	}

	
	
	
	
	
	
	
	
	
}
