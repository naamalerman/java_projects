package Exams;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.lang.Number;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class training implements H{
	public class Rec{
		public void printy() {
			System.out.println("notwork");
		}
	}
	public class ColorRec extends Rec{
		public void printy() {
			System.out.println("work");
		}
	}
	
	public boolean equals(Object o){
		return true;
	}
	
	public void f() {}
	public static int i=0;
	
	
	
    public static void main(String[] args){
    	B m = new D();
		System.out.println(m.func());
    	
    	
    	System.out.println();
    	B b = new B();
    	
    	List<Integer> n = Arrays.asList(1,2,3);
    	Set<Integer> s = new HashSet<>();
    	s.add(1);
    	s.add(2);
    	Stream<Integer> s1 = s.stream()
    			.sorted((x,y)->Integer.compare(x,y));
//    			.collect(Collectors.toSet());
    	s.remove(7);
    	System.out.println(s1.count());
//    	Stream<Integer> s = Stream.generate(new Natural());
//    	s.filter(x-> x>10)
//    	.anyMatch(x-> {System.out.println("_");return x%10==0;});
    	
    	n.stream().skip(2).forEach(x->System.out.println(x));
    	List lst = Arrays.asList(1,2,3);
    	Integer in = (Integer) lst.get(0);
    	Integer j = (int) lst.get(0);
		
    	int[] arr = {1,2,4,5};
    	System.out.println(arr[1]==Math.max(arr[0], arr[1]));
    	H t = new training();
    	
    	
    	System.out.println("_");
    	Object o = new Object();
    	
    	H comp4 = new H() {
    		public int comp(int x, int y) {
    			return x+y;
    		}
    	};
    	
    	H comp1 = (x,y)->x*2;
    	H comp2 = (x,y)->y+2;
    	
    	H comp3 = (x,y)-> comp1.comp(x, y)+comp2.comp(x, y);
    	
    	System.out.println(comp3.comp(1, 2)+comp4.comp(0, 3));
    	
//    	Stream<Integer> s = Stream.generate(new Natural());
//    	s.filter(x-> x%10==0 && x>5)
//    			.filter(x-> {System.out.println("!"); return x<50;})
//    			.forEach(x->System.out.println("!"));
//    	B b = (B) new A();
//    	b.Bfunc();
    }

	@Override
	public int comp(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	} 
    

}