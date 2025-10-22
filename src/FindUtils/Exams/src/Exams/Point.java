package Exams;

import java.util.Set;
import java.util.TreeSet;

public class Point implements Comparable<Point>{
	int i;
	int j;
	
	public Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	public int compareTo(Point other) {
		int compByI = Integer.compare(this.i, other.i);
		if (compByI==0) {
			return Integer.compare(this.j, other.j);
		}
		return -compByI;
	}
	
	public int hashCode() {
		return this.i;
	}
	
	public boolean equals(Object other) {
		return this.i == ((Point) other).i;
	}
	
	public static void main(String[] args) {
		Set<Point> m = new TreeSet<>();
		m.add(new Point(1,2));
		m.add(new Point(1,1));
		m.add(new Point(2,2));
		System.out.println(m.size());
	}

}
