package Exams;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class B<K> extends A{
	
	public int i = 1;
	public static void c() {}
//	public int func(String o) { return 4*i;}
	public void f(A a) {System.out.println("2");}

//	public Object func(String str){
//	    return super.func(str);
//	}
	
	public static void main(String[] args) {

//		System.out.print(b.foo("a"));

		
		B b = new B();
		b.f(b);
		Object o = "abc";
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(2);

		String s1 = "hello";
		String s2 = "hello";
		String s3 = new String("hello");
		String s4 = new String("hello");
		System.out.println(s1==s2);
		System.out.println(s4.equals(s3));
		System.out.println(s4==s3);
		
	}
}
