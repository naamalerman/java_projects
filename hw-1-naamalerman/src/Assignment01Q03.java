
public class Assignment01Q03 {

	public static void main(String[] args) {
		int numOfOdd = 0;
		
		
		int n = Integer.parseInt(args[0]);
		// *** your code goes here below ***
		
		System.out.println("The first "+ n +" Fibonacci numbers are:");
		// *** your code goes here below ***
		int[] fib_list = new int[n];
		fib_list[0]=1;
		fib_list[1]=1;
		for (int i = 2; i<n; i++) {
			fib_list[i] = fib_list[i-1]+fib_list[i-2];
		}
		
		String res = "";
		for (int i = 0; i<fib_list.length; i++) {
			res+=fib_list[i]+" ";
			if (fib_list[i]%2!=0) {
				numOfOdd++;
			}
		}
		
		res = res.substring(0, res.length() - 1);
		System.out.println(res);
		System.out.println("The number of odd numbers is: "+numOfOdd);
		
	
	}	
}
