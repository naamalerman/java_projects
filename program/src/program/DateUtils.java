package program;

public class DateUtils {
	public static int calculateDaysBetween(int day1, int month1, int year1, int day2, int month2, int year2) {
		 return Math.abs((year2-year1)*360+(month2-month1)*30+day2-day1);
	}
	public static boolean isLeapYear(int year) {
		if (year%4==0 && year%100!=0) {
			return true;
		}
		return false;
	}
	public static String getDayOfWeek(int day, int month, int year) {
		String[] days = {"Saturday", "Monday", "Tuesday", "Wednsday", "Thursday", "Friday"};
		int count = (2000-year)*360+(1-month)*30+1-day;
		int getDay = count%7;
		if (getDay<0) {
			getDay = getDay*(-1);
		}
		return days[getDay];
	}
	public static String zfill2(String arg) {
		while (arg.length()<2) {
			arg="0"+arg;
		}
		return arg;
	}
	public static String formatDate(int day, int month, int year) {
		String format = "%s-%s-%s";
		String dayS = Integer.toString(day);
		String monthS = Integer.toString(month);
		String yearS = Integer.toString(year);
		dayS = zfill2(dayS);
		monthS = zfill2(monthS);
		return String.format(format, dayS, monthS, yearS);
	}
}
