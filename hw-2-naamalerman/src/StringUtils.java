import java.util.Arrays;

public class StringUtils {
	public static String findSortedSequence(String str) {
		String[] words = str.split(" ");
		if (words.length == 0) {
			return "";
		}
		int[] maxCount = {0,0};
		int[] checkCount = {0,0};
		
		for (int i=0; i<words.length-1; i++) {
			String[] curWords = {words[i], words[i+1]};
			Arrays.sort(curWords);
			if (curWords[0].equals(words[i])) {
				checkCount[1] = i+1;
			}
			else {
				if ((maxCount[1]-maxCount[0])<=checkCount[1]-checkCount[0]) {
					maxCount[0] = checkCount[0];
					maxCount[1] = checkCount[1];
				}
				checkCount[0] = i+1;
				checkCount[1] = i+1;
			}
		}
		if ((maxCount[1]-maxCount[0])<=checkCount[1]-checkCount[0]) {
			maxCount[0] = checkCount[0];
			maxCount[1] = checkCount[1];
		}

		
		String txt = "";
		for (int i=maxCount[0]; i<=maxCount[1]; i++) {
			txt+=words[i]+" ";
		}
		
		return txt.substring(0, txt.length() - 1); 

	}
	
	public static boolean isDIff(String arr1, String arr2, int diff) {
		int a1Pointer = 0;
		int a2Pointer = 0;
		int counter = 0;
		
		while (a1Pointer<arr1.length() && a2Pointer<arr2.length()) {
			if (arr1.charAt(a1Pointer)!=arr2.charAt(a2Pointer)) {
				counter++;
				a1Pointer+=diff;
				
			}
			else {
				a1Pointer++;
				a2Pointer++;
			}
			
			
			if (counter>1) return false;
		}
		
		return true;
	}
	
	public static boolean isEditDistanceOne(String a, String b){
		if (a.length()-b.length()>1 || a.length()-b.length()<-1) {
			return false;
		}
		
		if (a.length()>=b.length()) {
			return isDIff(a, b, a.length()-b.length());
		}
		
		return isDIff(b, a, b.length()-a.length());
	}
	
}
