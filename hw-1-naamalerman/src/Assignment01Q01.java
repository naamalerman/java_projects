
public class Assignment01Q01 {

	public static void main(String[] args) {
		// *** your code goes here below ***
		for(int i=0; i<args.length; i++) {
			String[] words = (args[i]).split(" ");
			for(int j=0; j<words.length; j++) {
				
				char first_ch = words[j].charAt(0);
				
				if ((int) first_ch % 5 == 0)
					System.out.println(first_ch);
			}
		}
	}

}
