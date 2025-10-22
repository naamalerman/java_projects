package Exams;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A{
	
	private String str = "A";
	public G g;
	

	public void f(B b) {System.out.println("1");}

	public class G {
		public String s = "B";
		public G() {
			System.out.println(g.s);
		}
	}
	
	public static void main(String[] args){
		int[] arr = new int[10];
		int[] arr1 = arr.clone();
		List l = new ArrayList<>();
		

		
	}
	
}