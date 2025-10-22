package program;

public class DateTest {
	public static void main(String[] args) {
		String d1 = DateUtils.formatDate(20,8,2002);
		String d2 = DateUtils.formatDate(20,8,2002);
		boolean b = DateUtils.isLeapYear(2004);
		String d3 = DateUtils.getDayOfWeek(2,1,2000);
		
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(b);
		System.out.println(d3);
		
	}

}
